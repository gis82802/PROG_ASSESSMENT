/*
 * name:楊峻朋
 * 學號:41043229
 * 班級:資二乙
 */
public class b {
    public static void main(String[] args) {
        Company co = new Company();
        co.show(0);
        co.show(1);
        co.show(2);

    }
}
class Employee{
    int money=0;
    String name;
    void calculatePay(){

    }
    void displayEmployeeInfo(){
        System.out.println(name);
    }
    void show(){
        displayEmployeeInfo();
        System.out.println(money);
    }
}
class HourlyEmployee extends Employee{
    int hour;
    int HourMoney=50;
    public HourlyEmployee(int h,String n){
        hour= h;
        name = n;
    }
    void calculatePay(){
        money = hour * HourMoney;
    }

}
class SalaryEmployee extends Employee{
    int base=1000;
    int days;
    int DaysMoney=1000;
    public SalaryEmployee(int d,String n){
        days = d;
        name = n;
    }
    void calculatePay(){
        money = base + days*DaysMoney;
    }

}
class CommissionEmployee extends Employee{
    int month;
    int MonthMoney = 3000;
    public CommissionEmployee(int m,String n){
        month = m;
        name = n;
    }
    void calculatePay(){
        money = month*MonthMoney;
    }

}
class Company{
    Employee a[] = new Employee[3];

    public Company(){
        a[0] = new HourlyEmployee(10,"tom");

        a[1] = new SalaryEmployee(10,"jerry");
    
        a[2] = new CommissionEmployee(10,"jeff");
    }
    public void calculatePay(int i){
        a[i].calculatePay();
    }
    public void show(int i){
        calculatePay(i);
        a[i].show();
    }

}