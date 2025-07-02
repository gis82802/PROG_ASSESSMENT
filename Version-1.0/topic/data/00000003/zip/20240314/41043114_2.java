/*
資工二甲 41043114 吳俊憲
hw2
ver 1.0.0
*/
class Employee
{
    String name;
    int age;
    public int calculatePay()
    {
        return 0;
    }
    public void displayEmployeeInfo()
    {
        System.out.println("名字:"+name+"\n年齡"+age);
    }

}
class HourlyEmployee extends Employee
{
    HourlyEmployee(String n,int a)
    {
        name=n;
        age=a;
    }
    public int calculatePay()
    {
        return 30*150*8;
    }
}
class SalaryEmployee extends Employee
{
    SalaryEmployee(String n,int a)
    {
        name=n;
        age=a;
    }
    public int calculatePay()
    {
        return 40000;
    }
}
class CommissionEmployee extends Employee
{
    CommissionEmployee(String n,int a)
    {
        name=n;
        age=a;
    }
    public int calculatePay()
    {
        return 45000;
    }
}
class company
{
    int sum;
    Employee em[]=new Employee[5];
    company()
    {

        em[0]=new HourlyEmployee("John",20);
        em[1]=new SalaryEmployee("Mary",30);
        em[2]=new CommissionEmployee("Hans",35);
        em[3]=new SalaryEmployee("Bill",25);
        em[4]=new HourlyEmployee("Leo",20);
    }
    public int cal()
    {
        for(int i=0;i<em.length;i++)
        {
            sum+=em[i].calculatePay();
        }
        return sum;
    }

}
public class hw2
{
    public static void main(String[] args) 
    {
        company cm=new company();
        System.out.println("公司月薪總和:"+cm.cal());
        cm.em[0].displayEmployeeInfo();
    }
}