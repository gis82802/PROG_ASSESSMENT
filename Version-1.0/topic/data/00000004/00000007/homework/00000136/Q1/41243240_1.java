/*
filename:hw1
function:輸入陣列大小與內容，並將內容作排序
author:傅學呈
data:2024/10/18
version:11.0.12
*/

import java.util.Scanner;

public class hw1 {
    public static void main(String[] args) {

	Scanner scanner = new Scanner(System.in);
	System.out.print("輸入陣列大小:");
	int n=scanner.nextInt(); //當作陣列大小
	int arr[]=new int[n];

	System.out.print("輸入"+n+"個陣列內容:");
	for(int i=0;i<n;i++){
		arr[i]=scanner.nextInt();
	}

	System.out.print("未排序前:");
	for(int i=0;i<n;i++){
		System.out.print(arr[i]+" ");
	}
	System.out.println(" ");
	//由小到大的排序
	for(int j=0;j<n-1;j++){
		for(int i=0;i<n-1;i++){
		int temp;
			if(arr[i]>arr[i+1]){
				temp=arr[i+1];
				arr[i+1]=arr[i];
				arr[i]=temp;
			}
		}
	}
	System.out.print("(由小到大)排序後:");
	for(int i=0;i<n;i++){
		System.out.print(arr[i]+" ");
	}
	//由大到小的排序
	for(int j=0;j<n-1;j++){
		for(int i=0;i<n-1;i++){
		int temp;
			if(arr[i]<arr[i+1]){
				temp=arr[i+1];
				arr[i+1]=arr[i];
				arr[i]=temp;
			}
		}
	}
	System.out.println(" ");
	System.out.print("(由大到小)排序後:");
	for(int i=0;i<n;i++){
		System.out.print(arr[i]+" ");
	}

    }
}
