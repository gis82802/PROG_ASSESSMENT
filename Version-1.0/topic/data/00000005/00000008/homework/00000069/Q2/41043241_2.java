/*
41043241
*/ 
abstract class Employee{
    String name;
    String identity;
    int salary;
    Employee(String a,String b,int c){
        name = a;
        identity = b;
        salary = c;
    }
    abstract int calculatePay();
    abstract void displayEmployeeInfo();
}
class HourlyEmployee extends Employee{
    HourlyEmployee(String a,int c){
        super(a,"HourlyEmployee",c);
    }
    int calculatePay(){
        return 30 * 10 * salary;
    }
    void displayEmployeeInfo(){
        System.out.println("name : "+name);
        System.out.println("identity : "+identity);
        System.out.println("salary : "+salary+" /hour");
    }
}
class SalaryEmployee extends Employee{
    SalaryEmployee(String a,int c){
        super(a,"SalaryEmployee",c);
    }
    int calculatePay(){
        return salary;
    }
    void displayEmployeeInfo(){
        System.out.println("name : "+name);
        System.out.println("identity : "+identity);
        System.out.println("salary : "+salary+" /month");
    }
}
class CommissionEmployee extends Employee{
    CommissionEmployee(String a,int c){
        super(a,"CommissionEmployee",c);
    }
    int calculatePay(){
        return salary/12;
    }
    void displayEmployeeInfo(){
        System.out.println("name : "+name);
        System.out.println("identity : "+identity);
        System.out.println("salary : "+salary+" /year");
    }
}
public class hw2{
    public static void main(String args[]){
        int employees = 0;
        int total = 0;
        Employee[] company = new Employee[100];
        company[employees++] = new HourlyEmployee("AAA",200); //60000
        company[employees++] = new SalaryEmployee("BBB",50000);//50000
        company[employees++] = new CommissionEmployee("CCC",1200000);//100000
        company[employees++] = new HourlyEmployee("DDD",150);//45000
        company[employees++] = new CommissionEmployee("EEE",2400000);//200000
        company[employees++] = new SalaryEmployee("FFF",25000);//25000
        for(int i = 0 ;i<employees;i++){
            company[i].displayEmployeeInfo();
        }
        for(int i = 0 ;i<employees;i++){
            total += company[i].calculatePay();
        }
        System.out.println("company expenses : "+total+" /month");
    }
}