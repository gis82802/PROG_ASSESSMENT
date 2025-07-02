public class hw2_1
{
      public static void main(String arg[]){

	int n,i,x,y,z;

	for(z=1;z<=10000;z++){
		n=z;
		for(i=10000;i>1;i/=10){
			x=n/i;y=(n-x*i)/(i/10);
			n=n-x*i;
			if(x>y){
				break;}
			if(x!=0&&y!=0){
				if(x==y){
					break;
					}
		       	       }
		}
	
		if(i==1){
		System.out.println(z+" is well-ordered");}
		}
	}
	
}