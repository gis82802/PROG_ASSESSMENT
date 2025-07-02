import java.util.Random;

/*
	INFO:
	----------------------------------------
	FILE NAME:	hw20230314_2.java
	FUNCTION:	建立一父類別 "Employee"(員工) 具有二個成員函示 "calculatePay" 和 "displayEmployeeInfo"。
				建立繼承此父類別的子類別： "HourlyEmployee"(時薪員工), "SalaryEmployee"(正式員工), 和 "CommissionEmployee"(合約員工)，
				這三個子類別都會改寫(override) 成員函式 "calculatePay"，並依照其計薪方式計算月薪資。

				在主程式建立一個公司的物件，裡面包含這三種員工，計算這間公司一個月要發多少薪水來展示其功能。
				注意：這三種員工的物件要儲存在同一個陣列內
	AUTHOR(S):	41043243
	VERSION:	1.0
	----------------------------------------
*/
class References{
    public static int dailyHours = 8;
    public static int workdays = 18;
    public static int hourPay = 250;
}

class Employee{
    String employeeName = "";
    protected int workHours = References.dailyHours * References.workdays;

	public Employee(String name){
        employeeName = name;
		System.out.println("[INFO] Employee constructor called.");
	}
    public int calculatePay(){
        return References.hourPay * workHours;
    }
    public void setWorkHours(int hours, int days){
        References.dailyHours = hours;
        References.workdays = days;
        workHours = hours * days;
    }
	public String displayEmployeeInfo(){
		return "Name:\t" + employeeName;
	}
}

class HourlyEmployee extends Employee{
    public HourlyEmployee(String name){
        super(name);
    }
    public void setWorkHours(int hours, int days){
        workHours = hours * days;
    }
    public String displayEmployeeInfo(){
		return "Name:\t" + employeeName + " Type: Hourly";
	}
}

class SalaryEmployee extends Employee{
    public SalaryEmployee(String name){
        super(name);
    }
    public String displayEmployeeInfo(){
		return "Name:\t" + employeeName + " Type: Salary";
	}
}

class CommissionEmployee extends Employee{
    public CommissionEmployee(String name){
        super(name);
    }
    public String displayEmployeeInfo(){
		return "Name:\t" + employeeName + " Type: Commission";
	}
}

public class hw20230314_2{
	public static void main(String args[]){
		Employee[] RandomCompany = new Employee[3];
        RandomCompany[0] = new HourlyEmployee("Employee1");
        RandomCompany[1] = new SalaryEmployee("Employee2");
        RandomCompany[2] = new CommissionEmployee("Employee3");
        
        RandomCompany[0].setWorkHours(6, 20);

        int totalPayment = 0;
        for (int i = 0; i < RandomCompany.length; i++){
            System.out.println(RandomCompany[i].displayEmployeeInfo());
            System.out.println("Payment: " + RandomCompany[i].calculatePay());
            totalPayment += RandomCompany[i].calculatePay();
        }
        System.out.println("Total Payment: " + totalPayment);
	}
}