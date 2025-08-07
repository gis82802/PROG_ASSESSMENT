/*
version: v1.6.1
author : PIN CHEN, TSAI。
updated: 2025-08-07, (UTC+8)18:40。
*/

import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class main_v6 {
    // 如果return 0，表示成功通過測試；反之為失敗。
    
    public static void main(String[] args){
        // 1. 初步排查參數格式是否符合要求
        if (args.length != 3) {
            System.out.println("Usage: java main_v5 <FileDir> <FileName> <testcaseDir>");
            System.exit(1);
        }
        String FileDir   = args[0]; // eg. ../data/6/1/homework/108/Q1/
        String FileName  = args[1]; // eg. 41243154_01.java
        String testerDir = args[2]; // eg. ..data/6/1/tester/Q1/
        
        
        // 2. 核查目標資料是否存在
        Path HWDir = Paths.get(FileDir);   //待批改作業路徑
        Path TCDir = Paths.get(testerDir); //測資資料路徑
        
        if(!Files.exists(HWDir)) System.exit(2);
        if(!Files.exists(TCDir)) System.exit(-2);
        
        
        // 3. 讀取待批改作業
        File javaFile = HWDir.resolve(FileName).toFile();
        if(!javaFile.exists()){
            System.out.println("[ERROR] 找不到任何待批改作業，已終止批改。");
            System.exit(3);
        }
        
        
        // 4. 讀取測資資料
        //File[] inputFiles  = TCDir.toFile().listFiles((dir, name) -> name.endsWith(".in"));
        File[] outputFiles = TCDir.toFile().listFiles((dir, name) -> name.endsWith(".out"));
        if(outputFiles == null || outputFiles.length == 0){
            System.out.println("[ERROR] 找不到任何輸出測資，已終止批改。");
            System.exit(4);
        }
        
        
        // 5. 開始進行批改
        int allPassed = 0;             // 是否通過所有測資，否則不為0。
        for(File outFile : outputFiles){
            try{
                allPassed = runCompile(FileName, outFile, HWDir, TCDir);
            }catch(Exception e){
                e.printStackTrace();
                System.exit(7);
            }
            if(allPassed != 0){        // 任一測資無法通過，則跳出迴圈。
                break;
            }
        }
        if(allPassed == 5) System.exit(5);
        
        
        // 6. 回傳批改結果
        if(allPassed == 0){
            //System.out.println("成功通過所有測資測試");
            System.exit(0);
        }else{
            //System.out.println("未通過所有測資");
            System.exit(-1);
        }
        
    }
    
    
    private static int runCompile(String name, File outFile, Path nameDir, Path testDir) throws Exception{
        // 開始進行編譯
        
        
        // 如使用"直接執行程式"，請保持註解(本段未經過測試，程式碼可靠性未知)
        //尚未編寫Clear(); getClassName(name); function之功能，相關寫法請參考測資批改系統 "main_v4.java"撰寫。
        /*
        //清除殘留的.class檔案
        Clear();
        
        // 使用javac編譯成.class
        ProcessBuilder compile = new ProcessBuilder("javac", name);
        compile.directory(nameDir.toFile()); // 設定編譯路徑
        Process p1 = compile.start();
        int canCompile = p1.waitFor();       // 是否編譯成功
        if(canCompile != 0) return 5;
        
        // 執行程式(使用前請註解"直接執行程式的pb，方可使用。")
        String className = getClassName(name); // 搜尋資料夾中的.class檔名
        ProcessBuilder pb = new ProcessBuilder(java, className);
        */
        // 註解結束
        
        
        // 直接執行程式(限用java11以上之版本，否則得使用javac進行編譯)
        ProcessBuilder pb = new ProcessBuilder("java", name);
        pb.directory(nameDir.toFile());  // 設定執行路徑
        
        // 檢查是否有可用的輸入測資(true or false)
        String testName = outFile.getName().replace(".out", ""); // eg. 01.out -> 01
        File inFile = testDir.resolve(testName + ".in").toFile();
        if(inFile.exists()){
            // 如果輸入測資存在
            pb.redirectInput(inFile);
        }
        
        // 開始執行
        Process p2 = pb.start();
        
        // 讀取標準輸出(stdout)
        BufferedReader reader = new BufferedReader(new InputStreamReader(p2.getInputStream()));
        List<String> actual = new ArrayList<>(); // 儲存標準輸出結果
        String line;
        while((line = reader.readLine()) != null){
            actual.add(line);
        }
        
        // 程式碼超時判定
        boolean finished = p2.waitFor(5, java.util.concurrent.TimeUnit.SECONDS); //等待 5sec
        if(!finished){
            p2.destroyForcibly(); // 強制結束程式
            return 5;
        }
        
        // 檢查程式狀態，0表示正常結束程式，反之為失敗。
        int exitCode = p2.exitValue();
        if(exitCode != 0) return 5;
        
        // 檢核輸出是否與測資相同
        List<String> expected = new ArrayList<>(); // 存取測資輸出結果
        try(BufferedReader br = new BufferedReader(new FileReader(outFile))){
            while((line = br.readLine()) != null){
                expected.add(line);
            }
        }
        
        // 最後結果判定
        boolean ans = actual.equals(expected);
        if(ans){
            // 如果比對結果相同，則為通過。
            return 0;
        }
        
        return -1;
    }
    
}
