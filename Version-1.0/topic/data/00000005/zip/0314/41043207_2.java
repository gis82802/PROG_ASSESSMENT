/*
 * name: CHEN YUN YAO
 * studentID: 41043207
 * Functions : Employee
 * Date : 2023/03/14
 * filename : HW2.java
 */

public class HW2 {
    public static void main(String[] args){
        Company A = new Company();
        A.addEmployee("A", 1);
        A.addEmployee("B", 2);
        A.addEmployee("C", 3);
        A.employee[0].calculatePay();
        A.employee[1].calculatePay();
        A.employee[2].calculatePay();
    }
}

class Company{
    Employee employee[];
    int n;

    Company(){
        employee = new Employee[100];
        n = 0;
    }

    public void addEmployee(String name, int type){
        switch(type){
            case 1:
                HourlyEmployee a = new HourlyEmployee(name, 20);
                employee[n] = a;
                break;
            case 2:
                SalaryEmployee b = new SalaryEmployee(name,2);
                employee[n] = b;
                break;
            case 3:
                CommissionEmployee c = new CommissionEmployee(name, 3);
                employee[n] = c;
                break;
        }
        n++;
    }
}

class Employee{
    public void calculatePay(){

    }
    public void displayEmployeeInfo(){
        
    }
}

class HourlyEmployee extends Employee{
    int Hourly = 179;
    String name;
    int time;
    public void calculatePay() {
        System.out.println( 179 * time);
    }

    HourlyEmployee(String name, int time){
        this.name = name;
        this.time = time;
    }
}

class SalaryEmployee extends Employee{
    int monthlySalary = 35000;
    String name;
    int day = 22;
    int leave;
    public void calculatePay() {
        System.out.println(monthlySalary);
    }

    SalaryEmployee(String name, int leave){
        this.name = name;
        this.leave = leave;
    }
}

class CommissionEmployee extends Employee{
    int CommissionSalary = 28000;
    String name;
    int day = 22;
    int leave;
    
    public void calculatePay() {
        System.out.println(CommissionSalary);
    }

    CommissionEmployee(String name, int leave){
        this.leave = leave;
        this.name = name;
    }
}
