/*(2)建立一父類別 "Employee"(員工) 具有二個成員函示 "calculatePay" 和 "displayEmployeeInfo"。
建立繼承此父類別的子類別： "HourlyEmployee"(時薪員工), "SalaryEmployee"(正式員工), 和 "CommissionEmployee"(合約員工)，
這三個子類別都會改寫(override) 成員函式 "calculatePay"，並依照其計薪方式計算月薪資。
在主程式建立一個公司的物件，裡面包含這三種員工，計算這間公司一個月要發多少薪水來展示其功能。注意：這三種員工的物件要儲存在同一個陣列內 */
class Company
{
    Employee arr[] = new Employee[3];
}
class Employee 
{
    int calculatePay(){return 0;};
    void displayEmployeeInfo(){};
}
class HourlyEmployee extends Employee
{
    int hour,money;
    HourlyEmployee(int money,int hour)
    {
        this.money=money;
        this.hour = hour;
    }
    int calculatePay()
    {
        return hour*money;
    }
    void displayEmployeeInfo()
    {
        System.out.println("Hourly Employee");
    }
}
class SalaryEmployee extends Employee
{
    int money;
    SalaryEmployee(int money)
    {
        this.money = money;
    }
    int calculatePay()
    {
        return money;
    }
    void displayEmployeeInfo()
    {
        System.out.println("Salary Employee");
    }
}
class CommissionEmployee extends Employee
{
    int money;
    CommissionEmployee(int mon)
    {
        this.money = mon;
    }
    int calculatePay()
    {
        return money/12;
    }
    void displayEmployeeInfo()
    {
        System.out.println("Commission Employee");
    }
}
public class no2 
{
    public static void main(String args[])
    {
        Company com = new Company();
        com.arr[0] = new HourlyEmployee(200, 90);
        com.arr[1] = new SalaryEmployee(22000);
        com.arr[2] = new CommissionEmployee(360000);
        long sum = 0;
        for(int x=0;x<3;x++)
        {
            com.arr[x].displayEmployeeInfo();
            sum+=com.arr[x].calculatePay();
        }
        System.out.println("每個月支出:"+sum+"元");
    }
}