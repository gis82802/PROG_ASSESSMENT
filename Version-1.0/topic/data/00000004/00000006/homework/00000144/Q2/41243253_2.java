public class hw2_2 
{ 
    public static void main(String[] args) 
    {
	int sum=0;
	for(int num=1;num<=100000;num++)
	{
	    int x=0;  
	    int y=10;     //每個數值都會小於10
	    int temp=num; //temp來暫存num的內容
	    while(temp>0)
	    {  
  	       x=temp%10; //從最右邊的數字開始判斷
	       if(x<=y)
	       {
	           y=x;
	           temp/=10;  //刪掉右邊的數字
               }   
	       else
	       {
   		  break;
               }
	    }
	    if(temp==0)  //檢查輸入的數值是否已經全部判斷過
	    {   
               sum++;
	    }
	}
	System.out.println("1~100000之間有"+sum+"個well-ordered number");
    }
}
