public class mEmployee{
    public static void main(String[] args) {
       company com = new company();
       System.out.print("total:"); com.outmoney();
       System.out.println("info:");com.EmployeeInfo();
    }
}

class company {
    HourlyEmployee h ;
    SalaryEmployee s ;
    CommissionEmployee c;
    public company(){
        h = new HourlyEmployee(176, 20);
        s = new SalaryEmployee(50000);
        c = new CommissionEmployee(35000);
    }

    public void outmoney(){
        System.out.println(h.calculatePay()+s.calculatePay()+c.calculatePay());    
    } 

    public void EmployeeInfo(){
        h.displayEmployeeInfo();
        System.out.println("money"+h.calculatePay());
        s.displayEmployeeInfo();
        System.out.println("money"+s.calculatePay());
        c.displayEmployeeInfo();
        System.out.println("money"+c.calculatePay());
    }
}

class Employee{
    public Employee(){};
    public int calculatePay(){return 0;};
    public void displayEmployeeInfo(){};
}

class HourlyEmployee extends Employee{
    private int money;
    private int hour;
    public HourlyEmployee(int money,int hour){
        this.money = money;
        this.hour = hour;
    }
    @Override
    public int calculatePay(){ return hour*money;}
    public void displayEmployeeInfo(){System.out.println("Hourly");}
}

class SalaryEmployee extends Employee{
    private int money;
    public SalaryEmployee(int money){this.money= money;}
    @Override
    public int calculatePay(){ return money;}
    public void displayEmployeeInfo(){System.out.println("Salary");} 
}

class CommissionEmployee extends Employee{
    private int money;
    public CommissionEmployee(int money){this.money= money;}
    @Override
    public int calculatePay(){ return money;}
    public void displayEmployeeInfo(){System.out.println("Commission");} 
}
