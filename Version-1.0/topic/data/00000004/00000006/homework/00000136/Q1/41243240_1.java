/*
filename:PiCalculation1
function:判斷π=3.14159時最小的i為多少
author:傅學呈
data:2024/10/11
version:11.0.12
*/

public class PiCalculation1 {
    public static void main(String[] args) {
	int i=0;
	double currentpi=0; //用來儲存目前的π值
	double pi =0;	//存放計算π值
	//計算π值
	while(true){
		
	    	if(i%2==0){
            		pi=pi + 1.0 / (2*i+1);
        	    }
		else{
			pi=pi - 1.0 / (2*i+1);
		    }
		
		//將求出來的π四捨五入至小數點第五位
		currentpi = Math.round(pi * 4 * 100000.0) / 100000.0;
		
		//判斷π是否為3.14159
		if( currentpi==3.14159){
			System.out.println("當i = "+i+ " π= "+currentpi);
			break;
		}

		i++;
    }
	
  }
}
