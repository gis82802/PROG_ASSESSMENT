import java.util.HashMap;
import java.util.Map;

public class test {

    public static void main(String[] args) {
        final double MEMBER_DISCOUNT = 0.95;
        final double VIP_DISCOUNT = 0.9;
        
        DepartmentStore sogo = new DepartmentStore(MEMBER_DISCOUNT, VIP_DISCOUNT);
        
        // 使用外部類別物件來實例化內部類別
        DepartmentStore.Customer customer = sogo.new Customer();
        DepartmentStore.Member member = sogo.new Member();
        DepartmentStore.VIP vip = sogo.new VIP();

        System.out.println("---------- 一般顧客 ---------------");
        customer.printProductList();
        System.out.println();
        
        System.out.println("--------- 會員 ---------------");
        member.printProductList();
        System.out.println();
        
        System.out.println("----------- VIP --------------");
        vip.printProductList();
        System.out.println();
        
        System.out.println("------- 價格查詢 -----------");
        System.out.println("一般顧客 T恤: " + customer.getPrice("T恤"));
        System.out.println("會員 T恤: " + member.getPrice("T恤"));
        System.out.println("VIP T恤: " + vip.getPrice("T恤"));
    }
}

class DepartmentStore {
    // 定義所有商品的清單和價格
    private static final Map<String, Integer> ALL_PRODUCTS = new HashMap<>();
    static {
        ALL_PRODUCTS.put("糖果", 10);
        ALL_PRODUCTS.put("T恤", 250);
        ALL_PRODUCTS.put("帽子", 300);
        ALL_PRODUCTS.put("皮帶", 800);
        ALL_PRODUCTS.put("Limited_cup", 500);
        ALL_PRODUCTS.put("Limited_pen", 800);
        ALL_PRODUCTS.put("Limited_bottle", 300);
        ALL_PRODUCTS.put("手錶", 10000);
        ALL_PRODUCTS.put("眼鏡", 15000);
    }
    
    private double memberDiscount;
    private double vipDiscount;

    public DepartmentStore(double memberDiscount, double vipDiscount) {
        this.memberDiscount = memberDiscount;
        this.vipDiscount = vipDiscount;
    }

    // 基礎內部類別：一般顧客
    public class Customer {
        public void printProductList() {
            System.out.println("一般商品清單：");
            for (Map.Entry<String, Integer> entry : ALL_PRODUCTS.entrySet()) {
                if (entry.getKey().equals("Limited_cup") || entry.getKey().equals("Limited_pen") ||
                    entry.getKey().equals("Limited_bottle") || entry.getKey().equals("手錶") ||
                    entry.getKey().equals("眼鏡")) {
                    continue;
                }
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
        
        public double getPrice(String productName) {
            return ALL_PRODUCTS.getOrDefault(productName, 0).doubleValue();
        }
    }

    // 會員內部類別：繼承自 Customer
    public class Member extends Customer {
        @Override
        public void printProductList() {
            super.printProductList();
            System.out.println("會員專屬商品清單：");
            for (Map.Entry<String, Integer> entry : ALL_PRODUCTS.entrySet()) {
                if (entry.getKey().equals("Limited_cup") || entry.getKey().equals("Limited_pen") ||
                    entry.getKey().equals("Limited_bottle")) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
            }
        }

        @Override
        public double getPrice(String productName) {
            return super.getPrice(productName) * memberDiscount;
        }
    }

    // VIP內部類別：繼承自 Member
    public class VIP extends Member {
        @Override
        public void printProductList() {
            super.printProductList();
            System.out.println("VIP專屬商品清單：");
            for (Map.Entry<String, Integer> entry : ALL_PRODUCTS.entrySet()) {
                if (entry.getKey().equals("手錶") || entry.getKey().equals("眼鏡")) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
            }
        }

        @Override
        public double getPrice(String productName) {
            return super.getPrice(productName) * (vipDiscount / memberDiscount);
        }
    }
}