
/*
    fileName:h2.java
    function:as following
    author:41043246賴昱銘
    date:2023/03/14
    version:1.0
    HourlyEmployee SalaryEmployee CommissionEmployee
時薪員工正式員工合約員工
    (2)建立一父類別 "Employee"(員工) 具有二個成員函示 "calculatePay" 和 "displayEmployeeInfo"。建立繼承此父類別的子類別
    ： "HourlyEmployee"(時薪員工), "SalaryEmployee"(正式員工), 和 "CommissionEmployee"(合約員工)，
    這三個子類別都會改寫(override) 成員函式 "calculatePay"，並依照其計薪方式計算月薪資。在主程式建立一個公司的物件，
    裡面包含這三種員工，計算這間公司一個月要發多少薪水來展示其功能
*/
public class h2{
    public static void main(String[] args) {
        Company com=new Company();
        com.totalPayment();
    }
}
class Employee{
    String name;
    Employee(String name){this.name=name;}
    double calculatePay(){return 0;}
    void displayEmployeeInfo(){
        System.out.println("Employee name : "+name+"\tSalary: "+calculatePay());
    }
}
class HourlyEmployee extends Employee{
    int rate;
    int hours;
    HourlyEmployee(String name,int rate ,int hours){
        super(name);
        this.rate=rate;
        this.hours=hours;
    }
    @Override
    double calculatePay(){
        return rate*hours;
    }
}
class SalaryEmployee extends Employee{
    int salary;
    SalaryEmployee(String name,int salary){
        super(name);
        this.salary=salary;
    }
    @Override
    double calculatePay(){
        return salary;
    }
}
class CommissionEmployee extends Employee{
    double rate,sales;
    CommissionEmployee(String name,Double rate,Double sales){
        super(name);
        this.rate=rate;
        this.sales=sales;
    }
    @Override
    double calculatePay(){
        return rate*sales;
    }
}
class Company{
    Employee employees[];
    Company(){
        employees=new Employee[3];
        employees[0]=new HourlyEmployee("Andy",168,112);
        employees[1]=new SalaryEmployee("David",27000);
        employees[2]=new CommissionEmployee("Chris",120000.0,0.15);
    }
    void totalPayment(){
        double payment=0;
        for(int i=0;i<3;i++){
            payment+=employees[i].calculatePay();
            employees[i].displayEmployeeInfo();
        }
        System.out.println("company total payment :"+payment);
    }
}

