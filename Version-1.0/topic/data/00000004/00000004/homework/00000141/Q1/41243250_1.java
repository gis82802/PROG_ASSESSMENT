/*
filename:ch3_7.java
funtion:print 國立虎尾科技大學的 Unicode
author:劉宗修
date:2024/9/27
version:jdk23
*/
public class ch3_7
{
	public static void main(String[] args) throws Exception 
	{
		char[] uni=new char[]{'|','/','一','\\'};
		int i = 0;
       		 while(true)
		{
           		
                		Thread.sleep(200);
                		System.out.print(uni[i]);
          			i++;
                		Thread.sleep(200);
                		System.out.print("\r");
            			if(i==4)i=0;
        	}
	}
}