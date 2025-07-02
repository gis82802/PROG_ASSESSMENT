import java.util.Random;

/*
	INFO:
	----------------------------------------
	FILE NAME:	hw20230314_2.java
	FUNCTION:	�إߤ@�����O "Employee"(���u) �㦳�G�Ӧ������ "calculatePay" �M "displayEmployeeInfo"�C
				�إ��~�Ӧ������O���l���O�G "HourlyEmployee"(���~���u), "SalaryEmployee"(�������u), �M "CommissionEmployee"(�X�����u)�A
				�o�T�Ӥl���O���|��g(override) �����禡 "calculatePay"�A�è̷Ө�p�~�覡�p����~��C

				�b�D�{���إߤ@�Ӥ��q������A�̭��]�t�o�T�ح��u�A�p��o�����q�@�Ӥ�n�o�h���~���Ӯi�ܨ�\��C
				�`�N�G�o�T�ح��u������n�x�s�b�P�@�Ӱ}�C��
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