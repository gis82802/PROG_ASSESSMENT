/*
filename:hw2
function:輸入陣列大小與內容，根據當前陣列中最大或最小的數字(不包括自己)來去更改當前的數值，最後一項數字為-1
author:傅學呈
data:2024/10/18
version:11.0.12
*/

import java.util.Scanner;

public class hw2 {
    public static void main(String[] args) {

	Scanner scanner = new Scanner(System.in);
	System.out.print("輸入陣列大小:");
	int n=scanner.nextInt(); //當作陣列大小
	int arr[]=new int[n];
	int arr1[]=new int[n];
	System.out.print("輸入"+n+"個陣列內容:");
	for(int i=0;i<n;i++){
		arr[i]=scanner.nextInt();
	}
	
	for(int i=0;i<n;i++){
		arr1[i]=arr[i];
	}

	System.out.print("未排序前:");
	for(int i=0;i<n;i++){
		System.out.print(arr[i]+" ");
	}
	System.out.println(" ");
	int temp=arr[n-1];
	//最大值排序
	for(int i=0;i<n-1;i++){
		int max=0;
		//int min=arr[i];
		for(int j=i+1;j<n;j++){
			if(arr[j]>max)
				max=arr[j];
		}
		arr[i]=max;
	}
	arr[n-1]=-1;
	System.out.print("(max)排序後:");
	for(int i=0;i<n;i++){
		System.out.print(arr[i]+" ");
	}
	System.out.println(" ");


	//最小值排序
	for(int i=0;i<n-1;i++){
		int min=arr1[i];
		for(int j=i+1;j<n;j++){
			if(arr1[j]<min)
				min=arr1[j];
		}
		arr1[i]=min;
	}
	arr1[n-1]=-1;

	System.out.print("(min)排序後:");
	for(int i=0;i<n;i++){
		System.out.print(arr1[i]+" ");
	}
    }
}
