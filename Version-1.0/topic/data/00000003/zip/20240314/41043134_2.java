/*
function:Employee
date:3/14
name:ªô¬R¯ö
number:41043134
*/
public class hw1{
	public static void main(String args[]){
		String Ename[]={"Han","Peter Park","Jerry","Kenny"};
		int Epay[]={260,31000,210,240},Eyears[]={2,6,4,1},Etype[]={0,2,1,0},oth[]={170,13,21,180};
		company nfu=new company(Ename,Epay,Eyears,Etype,oth);
		nfu.info();
		nfu.count();
	}
}
class company{
	Employee all[];
	String en[];
	int ep[],ey[],et[];
	company(String inn[],int inp[],int iny[],int inty[],int o[]){
		all=new Employee[inn.length];
		en=inn;ep=inp;ey=iny;et=inty;
		for(int i=0;i<inn.length;i++){
			if(et[i]==0)
				all[i]=new HourlyEmployee(en[i],ep[i],ey[i],o[i]);
			else if(et[i]==1)
				all[i]=new SalaryEmployee(en[i],ep[i],ey[i],o[i]);
			else
				all[i]=new CommissionEmployee(en[i],ep[i],ey[i],o[i]);
		}
	}
	public void info(){
		System.out.print("EmployeeInfo:");
		for(int i=0;i<all.length;i++)
			all[i].displayEmployeeInfo();
	}
	public void count(){
		int t=0;
		for(int i=0;i<all.length;i++)
			t=t+all[i].calculatePay();
		System.out.print("\nmonthly payment: "+t);
	}	
}
class Employee{
	String name;
	int pay,years,type;
	Employee(){
		name="newb";
		pay=150;
		years=0;
		type=0;
	}
	Employee(String inn,int inp,int iny,int inty){
		name=inn;
		pay=inp;
		years=iny;
		type=inty;
	}
	public void displayEmployeeInfo(){
		System.out.print("\nName: "+name+" years: "+years+"years");
	}
	public int calculatePay(){
		return pay;
	}
}
class HourlyEmployee extends Employee{
	int p=250;
	int h=180;
	HourlyEmployee(String inn,int inp,int iny,int inh){
		super(inn,inp,iny,0);
		h=inh;
		p=inp;
	}
	public void displayEmployeeInfo(){
		super.displayEmployeeInfo();
		System.out.print(" work hours: "+h+"Hr type: Hourly Employee");
	}
	public int calculatePay(){
		
		return p*h;
	}
	
}
class SalaryEmployee extends Employee{
	int p=200;
	int day=20;
	SalaryEmployee(String inn,int inp,int iny,int ind){
		super(inn,inp,iny,2);
		day=ind;
		p=inp;
	}
	public int calculatePay(){
		
		return p*day*8;
	}
	public void displayEmployeeInfo(){
		super.displayEmployeeInfo();
		System.out.print(" work days: "+day+"days type: Salary Employee");
	}
}
class CommissionEmployee extends Employee{
	int p=34000;
	int m=12;
	CommissionEmployee(String inn,int inp,int iny,int inm){
		super(inn,inp,iny,2);
		m=inm;
		p=inp;
	}
	public void displayEmployeeInfo(){
		super.displayEmployeeInfo();
		System.out.print(" contract month: "+m+"month type: Commission Employee");
	}
}