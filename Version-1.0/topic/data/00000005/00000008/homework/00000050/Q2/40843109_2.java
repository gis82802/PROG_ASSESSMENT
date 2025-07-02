
class Employee {
    Employee(String name){
        this.name = name;
    }
    int calculatePay(){
        return salary;
    }
    void displayEmployeeInfo(){
        System.out.println("name : "+name);
        System.out.println("salary : "+salary);
    }
    String name;
    int salary;
}
class HourlyEmployee extends Employee {
    HourlyEmployee(String name,int work_hour,int hour_salary){
        super(name);
        this.work_hour = work_hour;
        this.hour_salary = hour_salary;
    }
    int calculatePay(){
        return hour_salary * work_hour;
    }
    void displayEmployeeInfo(){
        System.out.println("name : "+name);
        System.out.println("hour salary  : "+hour_salary);
        System.out.println("work hour : "+work_hour);
    }
    int work_hour;
    int hour_salary;
}
class SalaryEmployee extends Employee {
    SalaryEmployee(String name,int monthly_salary,int additional_salary){
        super(name);
        this.monthly_salary = monthly_salary;
        this.additional_salary = additional_salary;
    }
    int calculatePay(){
        return monthly_salary + additional_salary;
    }
    void displayEmployeeInfo(){
        System.out.println("name : "+name);
        System.out.println("monthly salary : "+monthly_salary);
        System.out.println("additional salary : "+additional_salary);
    }
    int monthly_salary;
    int additional_salary;

}
class CommissionEmployee extends Employee {
    CommissionEmployee(String name,int commission_salary){
        super(name);
        this.commission_salary = commission_salary;
    }
    int calculatePay(){
        return commission_salary;
    }
    void displayEmployeeInfo(){
        System.out.println("name : "+name);
        System.out.println("commission salary : "+commission_salary);
    }
    int commission_salary;
}
class Company{
    Company(){
        employees = new Employee[3];
        employees[0] = new HourlyEmployee("Alice",250,200);
        employees[1] = new SalaryEmployee("Bob",32000,7000);
        employees[2] = new CommissionEmployee("Carol",40000);
    }
    int calculatePay(){
        int n = 0;
        for(Employee index : employees){
            n += index.calculatePay();
        }
        return n;
    }
    void displayEmployeeInfo(){
        for(Employee index : employees){
            index.displayEmployeeInfo();
        }
    }

    Employee[] employees;
}
class app_2 {
    public static void main(String[] args) {
        Company company = new Company();
        company.displayEmployeeInfo();
        System.out.println("company calculatePay : " + company.calculatePay());
    }
}