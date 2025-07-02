/*
function:Inventory
date:3/14
name:ªô¬R¯ö
number:41043134
*/
public class hw1{
	public static void main(String args[]){
		Inventory BS=new Inventory();//BS=BeverageShop
		Inventory PS=new Inventory();//PS=PhoneShop
		BS.np("cola",50,20);
		BS.np("tea",60,15);
		PS.np("A53",10,10000);
		PS.np("iphone",20,20000);
		System.out.println("BeverageShop Inventory:");
		BS.printall();
		System.out.println("show price:"+BS.cal());
		System.out.println("\nPhoneShop Inventory:");
		PS.printall();
		System.out.println("show price:"+PS.cal());
		BS.addn("tea",20);
		System.out.println("\nadd drink amount BeverageShop Inventory:");
		BS.printall();
		System.out.println("show price:"+BS.cal());
		PS.reducen("A53",5);
		System.out.println("\nreduce phone amount PhoneShopp Inventory:");
		PS.printall();
		System.out.println("show price:"+PS.cal());
		System.out.println("\ndelete phone in PhoneShopp Inventory:");
		PS.dp("iphone");
		PS.printall();
		System.out.println("show price:"+PS.cal());
	}
}
class Inventory{
	Inventory(){
		leng=10;
		name=new String [leng];
		n=new int [leng];
		price=new int [leng];
		count=0;
	}
	int leng;
	String name[];
	int n[];
	int price[];
	private int count=0;
	void extend(){
		String tname[]=name;
		int tn[]=n;
		int tp[]=price;
		leng=leng*2;
		name=new String[leng];
		n=new int [leng];
		price=new int [leng];
		for(int i=0;i<tn.length;i++){
			name[i]=tname[i];
			n[i]=tn[i];
			price[i]=tp[i];
		}
		
	}
	public void addn(String in,int inn){
		int t=-1;
		for(int i=0;i<count;i++){
			if(name[i]==in){
				t=i;
				break;
			}
		}
		if(t==-1){
			System.out.print("wrong name\n");
			return;
		}
		n[t]=n[t]+inn;
	}
	public void reducen(String in,int inn){
		int t=-1;
		for(int i=0;i<count;i++){
			if(name[i]==in){
				t=i;
				break;
			}
		}
		if(t==-1){
			System.out.print("wrong name\n");
			return;
		}
		n[t]=n[t]-inn;
	}
	public int cal(){
		int total=0;
		for(int i=0;i<count;i++){
			total=total+n[i]*price[i];
		}
		return total;
	}
	public void np(String na,int inn,int inp){//np=newproduct
		if(count+1==leng)
			extend();
		name[count]=na;
		n[count]=inn;
		price[count]=inp;
		count++;
	}
	public void dp(String in){//dp=delete product
		int t=-1;
		for(int i=0;i<count;i++){
			if(name[i]==in){
				t=i;
				break;
			}
		}
		if(t==-1){
			System.out.print("wrong name\n");
			return;
		}
		for(int i=t;i<count-1;i++){
			name[i]=name[i+1];
			n[i]=n[i+1];
			price[i]=price[i+1];
		}
		count--;
		name[count]="";
		n[count]=0;
		price[count]=0;
	}
	public void printall(){
		for(int i=0;i<count;i++)
			System.out.print("name:"+name[i]+" amount:"+n[i]+" price:"+price[i]+"\n");
	}
}