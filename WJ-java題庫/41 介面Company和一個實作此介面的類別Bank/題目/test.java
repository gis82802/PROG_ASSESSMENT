import java.util.Scanner;

// Company 介面
interface Company {
    double getFixedAssets();
    double getCash();
    double getRevenue();
    double getCost();
}

// Bank 類別，實作 Company 介面
class Bank implements Company {
    private double cash;
    private double fixedAssets;
    private double revenue;
    private double cost;
    private double balance;

    public Bank(double cash, double fixedAssets, double revenue, double cost, double initialBalance) {
        this.cash = cash;
        this.fixedAssets = fixedAssets;
        this.revenue = revenue;
        this.cost = cost;
        this.balance = initialBalance;
    }

    // 實作 Company 介面方法
    @Override
    public double getFixedAssets() {
        return fixedAssets;
    }

    @Override
    public double getCash() {
        return cash;
    }

    @Override
    public double getRevenue() {
        return revenue;
    }

    @Override
    public double getCost() {
        return cost;
    }

    // Bank 類別特有方法
    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
        } else {
            System.out.println("餘額不足，提款失敗。");
        }
    }

    public void transfer(Bank other, double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            other.balance += amount;
        } else {
            System.out.println("餘額不足，轉帳失敗。");
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //System.out.println("設定第一家銀行的數據 (現金 固定資產 營收 成本):");
        Bank bankA = new Bank(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), 0);

        //System.out.println("設定第二家銀行的數據 (現金 固定資產 營收 成本):");
        Bank bankB = new Bank(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), 0);
        
        scanner.close();

        // 初始資訊展示
        System.out.println("--- 銀行 A 初始資訊 ---");
        System.out.println("現金: " + bankA.getCash());
        System.out.println("固定資產: " + bankA.getFixedAssets());
        System.out.println("每年營收: " + bankA.getRevenue());
        System.out.println("每年營運成本: " + bankA.getCost());
        
        System.out.println("--- 銀行 B 初始資訊 ---");
        System.out.println("現金: " + bankB.getCash());
        System.out.println("固定資產: " + bankB.getFixedAssets());
        System.out.println("每年營收: " + bankB.getRevenue());
        System.out.println("每年營運成本: " + bankB.getCost());
        
        System.out.println("\n--- 銀行功能展示 ---");

        // 存款功能
        bankA.deposit(10000);
        System.out.println("銀行 A 存款 10000");
        System.out.println("目前餘額: " + bankA.getBalance());
        
        // 提款功能
        bankB.deposit(20000); // 確保有足夠餘額
        bankB.withdraw(3000);
        System.out.println("銀行 B 提款 3000");
        System.out.println("目前餘額: " + bankB.getBalance());
        
        // 轉帳功能
        bankA.transfer(bankB, 4000);
        System.out.println("\n銀行 A 轉帳 4000 給 銀行 B");
        System.out.println("轉帳後銀行 A 餘額: " + bankA.getBalance());
        System.out.println("轉帳後銀行 B 餘額: " + bankB.getBalance());
    }
}