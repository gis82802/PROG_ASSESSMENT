import java.util.Map;
import java.util.HashMap;

class Inventory {
    Inventory() {
        product_map = new HashMap<String, product>();
    }

    private class product {
        public product(int price) {
            price_ = price;
        }

        public int amount_;
        public int price_;
    }

    public void add_product(String product_name, int price) {
        product_map.put(product_name, new product(price));
    }

    public void remove_product(String product_name) {
        product_map.remove(product_name);
    }

    public void increase_amount_product(String product_name, int amount) {
        product_map.get(product_name).amount_ += amount;
    }

    public void decrease_amount_product(String product_name, int amount) {
        product_map.get(product_name).amount_ -= amount;
    }

    public void show_product() {
        for (Map.Entry<String, product> entry : product_map.entrySet()) {
            System.out.println(
                    "product name :" + entry.getKey() +
                            "\n    price : " + entry.getValue().price_ +
                            "\n    amount : " + entry.getValue().amount_);
        }
    }

    public int total_product() {
        int cost = 0;
        for (Map.Entry<String, product> entry : product_map.entrySet()) {
            cost += entry.getValue().amount_ * entry.getValue().price_;
        }
        return cost;
    }

    private Map<String, product> product_map;
}

class app_1 {
    public static void main(String[] args) {
        Inventory drink_shop = new Inventory();
        Inventory phone_shop = new Inventory();
        drink_shop.add_product("tea", 25);
        drink_shop.add_product("milk tea", 40);
        drink_shop.increase_amount_product("tea", 50);
        drink_shop.increase_amount_product("milk tea", 30);
        drink_shop.show_product();
        System.out.println("total product price : " + drink_shop.total_product());
        
        System.out.println();

        phone_shop.add_product("iphone", 30000);
        phone_shop.add_product("htc one", 12000);
        phone_shop.increase_amount_product("iphone", 20);
        phone_shop.increase_amount_product("htc one", 60);
        phone_shop.show_product();
        System.out.println("total product price : " + phone_shop.total_product());
    }
}