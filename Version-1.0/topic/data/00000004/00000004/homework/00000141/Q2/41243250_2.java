/*
filename:ch3_6.java
funtion:print 國立虎尾科技大學的 Unicode
author:劉宗修
date:2024/9/27
version:jdk23
*/
public class ch3_6 {
	public static void main(String[] args){
		char[] uni=new char[]{'國','立','虎','尾','科','技','大','學','劉','宗','修'};

		for(int i = 0;i<11;i++){
			System.out.println(uni[i]+"="+((int)uni[i]));
		}		
	}
}