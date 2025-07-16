import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class main_v2{
    //初始化路徑
    static Path HWDir  = Paths.get("Homeworks"); //待批改作業路徑
    static Path TCDir  = Paths.get("Tester");    //測資資料路徑
    static Path logDir = Paths.get("logs");      //log存放路徑
    
    //計數器
    static int hwCounter      = 0; //計數所有待批改作業數量
    static int runCounter     = 0; //計數已編譯的程式數量
    static int successCounter = 0; //計數通過的作業數量
    static int failCounter    = 0; //計數未通過的作業數量
    
    public static void main(String[] args) throws Exception{
        //初始化名稱
        String logFileName = DateTimeFormatter.ofPattern("yyMMdd_HHmm").format(LocalDateTime.now()) + ".log"; //輸出log檔名
        
        //建立資料夾
        if(!Files.exists(HWDir))  {Files.createDirectories(HWDir);  System.out.println("[new] 已新增"+  HWDir.getFileName() +"資料夾。");}
        if(!Files.exists(TCDir))  {Files.createDirectories(TCDir);  System.out.println("[new] 已新增"+  TCDir.getFileName() +"資料夾。");}
        if(!Files.exists(logDir)) {Files.createDirectories(logDir); System.out.println("[new] 已新增"+ logDir.getFileName() +"資料夾。");}
        
        //讀取待批改作業
        File[] javaFiles = HWDir.toFile().listFiles((dir, name) -> name.endsWith(".java"));
        if(javaFiles == null || javaFiles.length == 0){
            System.out.println("[ERROR] 找不到任何待批改作業，已終止批改。");
            return;
        }else{
            System.out.println("已加載: "+ javaFiles.length +"份作業。");
        }
        
        //讀取測資資料
        File[] inputFiles  = TCDir.toFile().listFiles((dir, name) -> name.endsWith(".in"));
        File[] outputFiles = TCDir.toFile().listFiles((dir, name) -> name.endsWith(".out"));
        if(outputFiles == null || outputFiles.length == 0){
            System.out.println("[ERROR] 找不到任何輸出測資，已終止批改。");
            return;
        }else{
            System.out.println("已加載: "+ inputFiles.length +"份輸入測資，"+ outputFiles.length +"份輸出測資。");
        }
        hwCounter = javaFiles.length;
        
        //進行批改
        System.out.println();
        List<String> logs = new ArrayList<>(); //紀錄每份作業的結果
        for(File ja : javaFiles){
            String fileName = ja.getName(); //eg. 41243154_01.java
            
            int allPassed = 1;       //是否通過所有測資，否則不為1。
            for(File outFile : outputFiles){
                allPassed = runCompile(fileName, outFile);
                if(allPassed != 1){
                    break;
                }
            }
            
            //紀錄編譯結果
            if(allPassed == 1){
                successCounter += 1;
                logs.add(fileName + " -> Success.");
            }else{
                failCounter += 1;
                if(allPassed == 0)       logs.add(fileName + " -> Fail.(no pass)");
                else if(allPassed == -1) logs.add(fileName + " -> Fail.(no compile)");
                else if(allPassed == -2) logs.add(fileName + " -> Fail.(no Compile)");
                else                     logs.add(fileName + " -> Fail.");
                
            }
        }
        
        //將結果儲存至log檔案
        Path logFilePath = logDir.resolve(logFileName);  //log檔案路徑
        try(BufferedWriter writer = Files.newBufferedWriter(logFilePath)){
            for(String log : logs){
                writer.write(log + "\n");
            }
        }
        
        System.out.println("\n批改完成，" + successCounter + "份作業通過，" + failCounter + "份作業未通過。");
        System.out.println("已輸出log檔至 " + logFilePath);
    }
    
    private static int runCompile(String name, File outFile) throws Exception{
        runCounter += 1;
        System.out.println("編譯中: 第" + runCounter + "份作業(" + runCounter + "/" + hwCounter + ")。");
        
        //刪除殘留的.class檔案
        Clear();
        
        //編譯程式
        ProcessBuilder compile = new ProcessBuilder("javac", name);
        compile.directory(HWDir.toFile()); //設定編譯路徑
        Process p1 = compile.start();
        int canCompile = p1.waitFor();    //是否編譯成功
        if(canCompile != 0) return -1; //編譯失敗
        //System.out.println("done p1.");
        
        //執行程式(固定執行class main)
        String className = getClassName();
        ProcessBuilder pb = new ProcessBuilder("java", className);
        pb.directory(HWDir.toFile());     //設定執行路徑
        Process p2 = pb.start();
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(p2.getInputStream())); //讀取標準輸出(stdout)
        List<String> actual = new ArrayList<>(); //存取標準輸出結果
        String line;
        while((line = reader.readLine()) != null){
            actual.add(line);
        }
        
        int exitCode = p2.waitFor(); //檢查程式是否正常結束，0表示正常結束。
        if(exitCode != 0) return -2;
        
        //對比測資輸出
        List<String> expected = new ArrayList<>(); //存取測資輸出結果
        try(BufferedReader br = new BufferedReader(new FileReader(outFile))){
            while((line = br.readLine()) != null){
                expected.add(line);
            }
        }
        
        boolean ans = actual.equals(expected);
        //System.out.println("ans: " + ans);
        if(ans){return 1;
        }else{return 0;}
    }
    
    private static String getClassName(){
        //System.out.println("Hi");
        File[] classFiles = HWDir.toFile().listFiles((dir, name) -> name.endsWith(".class"));
        if(classFiles.length == 1){
            for(File cf : classFiles){
                //System.out.println("hehe.");
                return cf.getName().replace(".class", "");
            }
        }
        return "main";
    }
    
    private static void Clear(){
        File[] classFiles = HWDir.toFile().listFiles((dir, name) -> name.endsWith(".class"));
        if(classFiles != null || classFiles.length != 0){
            for(File cf : classFiles){
                cf.delete();
            }
        }
    }
}