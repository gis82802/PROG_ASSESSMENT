/*
   Author:��u�G�A 41043238 �B����
   datetime:2023/03/14
   version:1.0
   �{���\��:�إߤ@�����O "Employee"(���u) �㦳�G�Ӧ������ "calculatePay" �M "displayEmployeeInfo"�C�إ��~�Ӧ������O���l���O�G "HourlyEmployee"(���~���u), "SalaryEmployee"(�������u), �M "CommissionEmployee"(�X�����u)�A�o�T�Ӥl���O���|��g(override) �����禡 "calculatePay"�A�è̷Ө�p�~�覡�p����~��C�b�D�{���إߤ@�Ӥ��q������A�̭��]�t�o�T�ح��u�A�p��o�����q�@�Ӥ�n�o�h���~���Ӯi�ܨ�\��C�`�N�G�o�T�ح��u������n�x�s�b�P�@�Ӱ}�C��
            <���D�m�����O�B�~�ӡB�H�Φh�����[���P�{�����g>
*/
class Company
{
    Company(){}
    class Employee
    {
        protected int salary;
        protected String name; 
        protected String type; //�ΨӦs���u������ (Ex:���~ or ���� or �X��)
        Employee(){}
        void setType(String type){this.type = type;}
        int calculatePay(){return 0;}
        public void displayEmployeeInfo()
        {
            System.out.println("���u����:"+type+"�A���u�m�W:"+name+"�A�ӭ��u�~��:"+salary+"/��");
        }
    }
    class HourlyEmployee extends Employee
    {
        private final int minimum_wage = 176; //�̧C�~��
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
        employees[0].setType("���~���u");
        employees[1] = company.new SalaryEmployee("tina",20);
        employees[1].setType("�������u");
	employees[2] = company.new CommissionEmployee("Eric",1200000);
	employees[2].setType("�X�����u");
	int total_salary = employees[0].calculatePay() + employees[1].calculatePay() + employees[2].calculatePay();
        employees[0].displayEmployeeInfo();
        employees[1].displayEmployeeInfo();
	employees[2].displayEmployeeInfo();
	System.out.println("���q�@�Ӥ�@�ݭn�o:"+total_salary+"�~��");
    }
}