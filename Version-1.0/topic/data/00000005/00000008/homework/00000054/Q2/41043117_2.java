class Employee{
    String name,type;
    Employee(String Ename,String t){
        name=Ename;
        type=t;
    }
    public int calculatePayment(){
        return 0;
    }
   
    public void displayEmployeeInfo(){
        System.out.println("員工姓名："+name);
        System.out.println("員工類型："+type);
    }
}

class HourlyEmployee extends Employee{
    int hourSalary,WorkTime,WorkDay;

    HourlyEmployee(String Ename,int S,int T,int D){
        super(Ename,"HourlyEmployee");
        hourSalary=S;
        WorkTime=T;
        WorkDay=D;
    }

    public int calculatePay(){
        return hourSalary*WorkDay*WorkTime;
    }
}

class SalaryEmployee extends Employee{
    int MonthSalary;
    SalaryEmployee(String Ename,int S){
        super(Ename,"SalaryEmployee");
        MonthSalary=S;
    }

    public int calculatePay(){
        return MonthSalary;
    }
}

class CommissionEmployee extends Employee{
    int CommissionTime,Salary;
    CommissionEmployee(String Ename,int S,int D){
        super(Ename,"CommissionEmployee");
        Salary=S;
        CommissionTime=D;
    }

    public int calculatePay(){
        return Salary*CommissionTime;
    }
}

public class HW2_3_14 {
    public static void main(String[] args){
        HourlyEmployee john=new HourlyEmployee("John", 100, 5, 20);
        SalaryEmployee HAHA=new SalaryEmployee("HaHa", 30000);
        CommissionEmployee yee=new CommissionEmployee("Yee", 4500,10);

        john.displayEmployeeInfo();
        System.out.println("john這個月應得的薪資："+john.calculatePay());

        HAHA.displayEmployeeInfo();
        System.out.println("HaHa這個月應得的薪資："+HAHA.calculatePay());

        yee.displayEmployeeInfo();
        System.out.println("Yee這個月應得的薪資："+yee.calculatePay());
    }
}
