/*
    filename:hw4_1
    function:計算pi值
    author:41243204
    datetime:2024/10/11
    version:1.0
*/
 public class hw4_1
 {
  public static void main(String args[])
  {
   int maxn=100000;//設定值極限
   int add=10000;//每次計算值+10000
   double pi=0.0 ;  
    for(int current = add;current<=maxn;current+=add){
    for(int i=0;i<current;i++){
        if(i%2==0)
         pi+=1.0/(2*i+1);//如果i為偶數
        else 
         pi-=1.0/(2*i+1);//如果i為奇數
     }
     pi *= 4;//計算結果
     System.out.println("i="+current+",pi="+pi);
     pi=0;
   }
  }
}
//此程式使用空白鍵縮排，且變數皆有有意義之命名，方便閱讀。
