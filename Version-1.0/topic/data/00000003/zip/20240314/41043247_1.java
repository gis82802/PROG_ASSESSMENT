/*
 * Filename: ClassEmployee
 * Function: Employee 類別
 * Author: 41043247
 * Date: 2023/3/14
 */

import java.util.LinkedList;
public class ClassEmployee {
    public static void main(String[] args) {
        Company Google = new Company();
        Google.hire(new HourlyEmployee("Alice", false, 25));
        Google.hire(new SalaryEmployee("Candice", false, 28));
        Google.hire(new CommissionEmployee("Jessie", false, 30));
        Google.hire(new HourlyEmployee("Adam", true, 26));
        Google.hire(new SalaryEmployee("Bob", true, 24));
        Google.hire(new CommissionEmployee("David", true, 34));
        Google.Print();
        Google.PersonnelCosts();
    }
}
class Company {
    LinkedList<Employee> EmployeeList;
    Company() {
        EmployeeList = new LinkedList<Employee>();
    }
    void hire(Employee e) {
        EmployeeList.add(e);
    }
    void PersonnelCosts() {
        int sum = 0;
        for(int i=0; i<EmployeeList.size(); i++)
            sum += EmployeeList.get(i).calculatePay();
        System.out.println("Personnel cost per month: $" + sum);
    }

    void Print() {
        System.out.println("Name\tSex\tAge");
        for(int i=0; i<EmployeeList.size(); i++)
            EmployeeList.get(i).displayEmployeeInfo();
    }

}
class Employee {
    String name;
    boolean sex;
    int age;
    Employee() {}
    Employee(String name, boolean sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
    int calculatePay() {
        return 1;
    }
    void displayEmployeeInfo() {
        System.out.println(name + "\t" + (sex?"male":"female") + "\t" + age);
    }
}

class HourlyEmployee extends Employee {
    HourlyEmployee(String name, boolean sex, int age) {
        super.name = name;
        super.sex = sex;
        super.age = age;
    }
    int calculatePay() {
        return 176*8*22;
    }
}

class SalaryEmployee extends Employee {
    SalaryEmployee(String name, boolean sex, int age) {
        super.name = name;
        super.sex = sex;
        super.age = age;
    }
    int calculatePay() {
        return 1600*22;
    }
}

class CommissionEmployee extends Employee {
    CommissionEmployee(String name, boolean sex, int age) {
        super.name = name;
        super.sex = sex;
        super.age = age;
    }
    int calculatePay() {
        return 40000;
    }
}