/*
filename:java0927
funtion:中文轉Unicode
author:41243232
date:2024/09/27
version:jdk23
*/
public class java0927{

	public static void main(String[] args){
		
		char cUni[] = {'\u90ed','\u5ef7','\u5a01','\u570b','\u7acb','\u864e','\u5c3e','\u79d1','\u6280','\u5927','\u5b78','\u8cc7','\u8a0a','\u5de5','\u7a0b','\u7cfb'};
		char cCh[] = {'郭','廷','威','國','立','虎','尾','科','技','大','學','資','訊','工','程','系'};
		for(int i =0;i<3;i++)
		{
			System.out.print(cUni[i]);
			System.out.print("(" + String.format("\\u%04x", (int) cCh[i]) + ")");
		}
		System.out.println("");
		for(int i =3;i<16;i++)
		{
			System.out.print(cUni[i]);
			System.out.print("(" + String.format("\\u%04x", (int) cCh[i]) + ")");
		}
		
	}
}