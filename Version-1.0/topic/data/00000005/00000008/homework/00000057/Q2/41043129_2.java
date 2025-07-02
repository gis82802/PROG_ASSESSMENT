class Employee{
    public Employee(String N,int A) {
        this.name = N;
        this.age = A;
	}
    public int calculatePay(){
        return 0;
    }
    public void displayEmployeeInfo(){
        System.out.println("Name:"+this.name+" Age:"+this.age+" Salary:"+this.salary);
    }
    private String name;
	private int salary,age;
}
class HourlyEmployee extends Employee{
    public HourlyEmployee(String N,int A,int SA) {
        super(N,A);
        this.salary = SA;
	}
    public int calculatePay(){
        return this.salary*30*8;
    }
    private int salary;
}
class SalaryEmployee extends Employee{
    public SalaryEmployee(String N,int A,int SA) {
        super(N, A);
        this.salary = SA;
	}
    public int calculatePay(){
        return this.salary;
    }
    private int salary;
}
class CommissionEmployee extends Employee{
    public CommissionEmployee(String N,int A,int SA) {
        super(N, A);
        this.salary = SA;
	}
    public int calculatePay(){
        return this.salary/12;
    }
    private int salary;
}

class Company{
    public Company(Employee[] employees){
        this.employees = employees;
    }
    public void Total(){
        int total_salary=0;
        for(int i =0;i<3;i++){
            total_salary+=employees[i].calculatePay();
        }
        System.out.println("This Company need to paid "+total_salary+" every month");
    }
    private Employee[] employees;
}
public class homework2 {
    public static void main(String args[]){
        Employee[] employees = new Employee[3];
        employees[0] = new HourlyEmployee("Jerry", 25, 168);
        employees[1] = new CommissionEmployee("John", 30, 1440000);
        employees[2] = new SalaryEmployee("Tom", 20, 30000);

        Company company = new Company(employees);
        company.Total();
    }
}
