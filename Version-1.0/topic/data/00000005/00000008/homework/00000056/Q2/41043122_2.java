/*author:41043122�L���R
  date:03/14
  function:�p�⤽�q���~
	*/
class Employee
{
	int salary;
	int quan;
	int total=0;
	
	public int calculatePay()
	{
		return total;
	}
	public void displayEmplyeeInfo()
	{
	}

}
class HourlyEmplyee extends Employee
{
	public int calculatePay()
	{
		total=salary*240*quan;
		return total;
	}
	public HourlyEmplyee(int a,int b)
	{
		quan=b;
		salary=a;
	}
	public void displayEmplyeeInfo()
	{
		System.out.println("���~���u�H��="+quan);
		System.out.println("���~="+salary);
	}
}
class SalaryEmplyee extends Employee
{
	public int calculatePay()
	{
		total=quan*salary;
		return total;
	}
	public SalaryEmplyee(int a,int b)
	{
		quan=b;
		salary=a;
	}
	public void displayEmplyeeInfo()
	{
		System.out.println("�������u�H��="+quan);
		System.out.println("���~="+salary);
	}
}
class CommissionEmplyee extends Employee
{
	public int calculatePay()
	{
		total=quan*salary;
		return total;
	}
	public CommissionEmplyee(int a,int b)
	{
		quan=b;
		salary=a;
	}
	public void displayEmplyeeInfo()
	{
		System.out.println("�X�����u�H��="+quan);
		System.out.println("���~="+salary);
	}
}
public class work3142
{
	public static void main(String args[])
	{
		Employee company[]=new Employee[3];
		company[0]=new HourlyEmplyee(200,10);
		company[1]=new SalaryEmplyee(25000,25);
		company[2]=new CommissionEmplyee(20000,5);
		for(int i=0;i<3;i++)
		{
			company[i].displayEmplyeeInfo();
		}
		int tot=company[0].calculatePay()+company[1].calculatePay()+company[2].calculatePay();
		System.out.print("���q�@�Ӥ�n�I"+tot+"�����~��");
	}
}