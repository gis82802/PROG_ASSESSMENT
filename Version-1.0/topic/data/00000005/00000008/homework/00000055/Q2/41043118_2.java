package employee;
import java.util.ArrayList;
import java.util.Scanner;

//employee
//庫存類別
//呂昱諦
//1.0

public class CW2 
{
    public static void main(String[] args)
    {
        company new_Company = new company();
        new_Company.addHE();
        new_Company.addSE();
        new_Company.addCE();
        new_Company.calculate_monthly_wages();
    }
}
class Employee
{
    protected String name;
    protected String id;
    protected int pay;

    public Employee(String n, String i, int p)
    {
        name = n;
        id = i;
        pay = p;
    }
    public int calculatePay()
    {
        return pay;
    }
    public void displayEmployeeInfo()
    {
        System.out.println("員工姓名：" + name);
        System.out.println("ID：" + id);
        System.out.println("薪資：" + pay);
    }
}
class HourlyEmployee extends Employee
{
    final static int HOURLY_WAGE = 160;
    private int wh;

    public HourlyEmployee(String n, String i, int H)
    {
        super(n, i, HOURLY_WAGE);
        wh = H;
    }
    public int calculatePay()
    {
        int all;
        all = pay * wh;
        return all;
    }
    public void displayEmployeeInfo()
    {
        System.out.println("員工姓名：" + name);
        System.out.println("ID：" + id);
        System.out.println("時薪：" + pay);
    }
}
class SalaryEmployee extends Employee
{
    public SalaryEmployee(String n, String i, int p)
    {
        super(n, i, p);
    }
    public int calculatePay()
    {
        return pay;
    }
    public void displayEmployeeInfo()
    {
        System.out.println("員工姓名：" + name);
        System.out.println("ID：" + id);
        System.out.println("每月薪資：" + pay);
    }
}
class CommissionEmployee extends Employee
{
    private int liquidated_damages;
    private int mouth;

    public CommissionEmployee(String n, String i, int p, int m, int ld)
    {
        super(n, i, p);
        mouth = m;
        liquidated_damages = ld;
    }
    public int calculatePay()
    {
        return pay;
    }
    public void displayEmployeeInfo()
    {
        System.out.println("員工姓名：" + name);
        System.out.println("ID：" + id);
        System.out.println("合約每月薪資：" + pay);
        System.out.println("簽訂月數：" + mouth);
        System.out.println("違約金：" + liquidated_damages);
    }
}
class company
{
    private ArrayList<Employee> employees;

    public company()
    {
        employees = new ArrayList<Employee>();
    }
    public void addHE()
    {
        Scanner scn = new Scanner(System.in);
        String name;
        String id;
        int hour;
        System.out.print("員工姓名：");
        name = scn.nextLine();
        System.out.print("員工ID：");
        id = scn.nextLine();
        System.out.print("工作時數：");
        hour = scn.nextInt();
        employees.add(new HourlyEmployee(name, id, hour));
    }
    public void addSE()
    {
        Scanner scn = new Scanner(System.in);
        String name;
        String id;
        int pay;
        System.out.print("員工姓名：");
        name = scn.nextLine();
        System.out.print("員工ID：");
        id = scn.nextLine();
        System.out.print("員工每月薪資：");
        pay = scn.nextInt();
        employees.add(new SalaryEmployee(name, id, pay));
    }
    public void addCE()
    {
        Scanner scn = new Scanner(System.in);
        String name;
        String id;
        int pay;
        int mouth;
        int liquidated_damages;
        System.out.print("員工姓名：");
        name = scn.nextLine();
        System.out.print("員工ID：");
        id = scn.nextLine();
        System.out.print("合約每月薪資：");
        pay = scn.nextInt();
        System.out.print("簽訂月數：");
        mouth = scn.nextInt();
        System.out.print("違約金：");
        liquidated_damages = scn.nextInt();
        employees.add(new CommissionEmployee(name, id, pay, mouth, liquidated_damages));
    }
    public void calculate_monthly_wages()
    {
        int twages = 0;
        for(int i = 0;i < employees.size();i++)
            twages += employees.get(i).calculatePay();
        System.out.println("本月應發薪資為" + twages + "元");;
    }
}