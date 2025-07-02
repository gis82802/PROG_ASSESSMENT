import java.lang.Math;
import java.util.Scanner;
import java.util.Arrays;
public class hwc{
    
    public static void main(String[] args ){//第一題的A部分
    Scanner s = new Scanner(System.in);
    System.out.println("輸入你的陣列內容");
    int[] str = new int[11];
    int[] str2 = new int[11];
    int temp,a;
   for(int i=0;i<10;i++){
        str[i]=s.nextInt();
   }System.out.print("取代前的陣列：");
    for(int i=0;i<10;i++){
    System.out.print(str[i]+",");
    }
    System.out.print("\n");
   for(int i=0;i<10;i++){
    str2[i]=str[i];
   }
   str[10]=-1;
   
   
    
   for(int i=1;i<11;i++){
    for(int j=i+1;j<11;j++){
        if(str[i]<str[j])
            str[i]=str[j];
    }
   }   
   System.out.println("取代後的大到小陣列內容：");
    for(int i=1;i<11;i++)
    System.out.print(str[i]+",");
    //大到小結束
    //小到大開始
    for(int i=0;i<10;i++){
    for(int j=i+1;j<10;j++){
        if(str2[i]>str2[j])
            str2[i]=str2[j];
    }
    }
   str2[10]=-1;
   System.out.println("取代後的小到大陣列內容：");
    for(int i=1;i<11;i++){
    System.out.print(str2[i]+",");
    }
    }
}

