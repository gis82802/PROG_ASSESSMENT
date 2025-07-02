import java.util.Scanner;
class Employee{
    String EmployeeInfo;
    public Employee(){
    }
    void calculatePay(int money){
    }
    void displayEmployeeInfo(){
        System.out.println("This Employee is a "+EmployeeInfo);
    }
}

class HourlyEmployee extends Employee{
    HourlyEmployee(){
        this.EmployeeInfo="HourlyEmployee";
    }
    void calculatePay(int money){
        System.out.println("We need pay this guy "+ money +" dollars in this month");
    }
}
class SalaryEmployee extends Employee{
    SalaryEmployee(){
        this.EmployeeInfo="SalaryEmployee";
    }
    void calculatePay(int money){
        System.out.println("We need pay this guy "+ money +" dollars in this month");
    }
}
class CommissionEmployee extends Employee{
    CommissionEmployee(){
        this.EmployeeInfo="CommissionEmployee";
    }
    void calculatePay(int money){
        System.out.println("We need pay this guy "+ money +" dollars in this month");
    }
}


public class lab2_0314{
public static void main(String args[]){
    Scanner scn=new Scanner(System.in);
    Employee[] people=new Employee[3];
    
    people[0]=new HourlyEmployee();
    people[0].displayEmployeeInfo();
    System.out.println("Please input HourlyEmployee's money of every hours");
    int money=scn.nextInt();
    people[0].calculatePay(money);

    people[1]=new SalaryEmployee();
    people[1].displayEmployeeInfo();
    System.out.println("Please input SalaryEmployee's money of every month");
    money=scn.nextInt();
    people[1].calculatePay(money);

    people[2]=new CommissionEmployee();
    people[2].displayEmployeeInfo();
    System.out.println("Please input CommissionEmployee's money of every years");
    money=scn.nextInt();
    people[2].calculatePay(money);
    }
}