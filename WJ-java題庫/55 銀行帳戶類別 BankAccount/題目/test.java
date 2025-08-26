import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class BankAccount {
    private String name;
    private double balance;
    private List<String> transactions;
    
    public BankAccount(String name, double initialBalance) {
        this.name = name;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
        this.transactions.add(String.format("存款 %.1f 元, 日期: %s", amount, getFormattedDate()));
    }

    public void withdraw(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            this.transactions.add(String.format("提款 %.1f 元, 日期: %s", amount, getFormattedDate()));
        } else {
            System.out.println("餘額不足，提款失敗。");
        }
    }

    public void transferTo(BankAccount receiver, double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            receiver.deposit(amount);
            
            String date = getFormattedDate();
            this.transactions.add(String.format("轉帳 %.1f 元給 %s, 日期: %s", amount, receiver.getName(), date));
            receiver.transactions.add(String.format("收到來自 %s 的轉帳 %.1f 元, 日期: %s", this.name, amount, date));
            
        } else {
            System.out.println("餘額不足，轉帳失敗。");
        }
    }
    
    public void queryTrans() {
        System.out.println(this.name + " 的交易紀錄：");
        for (String record : transactions) {
            System.out.println(record);
        }
    }
    
    private String getFormattedDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("2077-12-10");
        LocalDate localDate = LocalDate.now();
        return dtf.format(localDate);
    }
}

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 建立三個銀行帳戶
        BankAccount mary = new BankAccount("Mary", 5000);
        BankAccount john = new BankAccount("John", 1000);
        BankAccount peter = new BankAccount("Peter", 2000);
        
        //System.out.print("請輸入轉帳金額 x (John 轉給 Peter): ");
        double x = scanner.nextDouble();
        
        //System.out.print("請輸入轉帳金額 y (Mary 轉給 John): ");
        double y = scanner.nextDouble();
        
        scanner.close();
        
        // 執行轉帳
        john.transferTo(peter, x);
        mary.transferTo(john, y);
        
        // 查詢 John 的交易紀錄
        john.queryTrans();
    }
}