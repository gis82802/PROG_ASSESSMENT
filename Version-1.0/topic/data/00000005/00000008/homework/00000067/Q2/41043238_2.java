/*
   Author:資工二乙 41043238 劉章佑
   datetime:2023/03/14
   version:1.0
   程式功能:建立一父類別 "Employee"(員工) 具有二個成員函示 "calculatePay" 和 "displayEmployeeInfo"。建立繼承此父類別的子類別： "HourlyEmployee"(時薪員工), "SalaryEmployee"(正式員工), 和 "CommissionEmployee"(合約員工)，這三個子類別都會改寫(override) 成員函式 "calculatePay"，並依照其計薪方式計算月薪資。在主程式建立一個公司的物件，裡面包含這三種員工，計算這間公司一個月要發多少薪水來展示其功能。注意：這三種員工的物件要儲存在同一個陣列內
            <本題練習類別、繼承、以及多型的觀念與程式撰寫>
*/
class Company
{
    Company(){}
    class Employee
    {
        protected int salary;
        protected String name; 
        protected String type; //用來存員工的類型 (Ex:時薪 or 正式 or 合約)
        Employee(){}
        void setType(String type){this.type = type;}
        int calculatePay(){return 0;}
        public void displayEmployeeInfo()
        {
            System.out.println("員工類型:"+type+"，員工姓名:"+name+"，該員工薪水:"+salary+"/月");
        }
    }
    class HourlyEmployee extends Employee
    {
        private final int minimum_wage = 176; //最低薪資
        private int hour;
        private int day;
        HourlyEmployee(String name,int hour,int day)
        {
            super.name = name;
            this.hour = hour;
            this.day = day;
        }
        int calculatePay()
        {
            super.salary = hour * minimum_wage * day;
	    return super.salary;
        }
    }
    class SalaryEmployee extends Employee
    {
        private int day_salary = 2000;
        private int day;
        SalaryEmployee(String name,int day)
        {
            super.name = name;
            this.day = day;
        }
        int calculatePay()
        {
            super.salary = day_salary * day;
	    return super.salary;
        }
    }
    class CommissionEmployee extends Employee
    {
	private int year_salary;
	CommissionEmployee(String name,int year_salary)
	{
	    this.year_salary = year_salary;
	    super.name = name;  
	}
	int calculatePay()
	{
	    super.salary = (int)year_salary / 12;
            return super.salary; 
	}
    }
    
}
public class HomeWork2
{
    public static void main(String args[])
    {
        Company company = new Company();
        Company.Employee[] employees = new Company.Employee[3];
        
        employees[0] = company.new HourlyEmployee("Allen",10,10);
        employees[0].setType("時薪員工");
        employees[1] = company.new SalaryEmployee("tina",20);
        employees[1].setType("正式員工");
	employees[2] = company.new CommissionEmployee("Eric",1200000);
	employees[2].setType("合約員工");
	int total_salary = employees[0].calculatePay() + employees[1].calculatePay() + employees[2].calculatePay();
        employees[0].displayEmployeeInfo();
        employees[1].displayEmployeeInfo();
	employees[2].displayEmployeeInfo();
	System.out.println("公司一個月共需要發:"+total_salary+"薪水");
    }
}