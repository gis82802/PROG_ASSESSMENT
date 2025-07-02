class Inventory {
	public Inventory(String N,int A,int P) {
		this.name = N;
		this.amount = A;
		this.price = P;
		System.out.println("add product:"+N+" amount:"+A+" price:"+P);
	}
	public void add_product(String N,int A,int P) {
		if(this.name.equals(N)) {
			System.out.println("This product already exist,and add "+A+" amount");
			this.amount+=A;
		}else {
			System.out.println("add product:"+N+" amount:"+A+" price:"+P);
			this.name = N;
			this.amount = A;
			this.price = P;
		}
	}
	public void reduce_product(String N) {
		if(this.name.equals(N)) {
			System.out.println("remove product:"+N);
			this.amount=0;
			this.price=0;
		}else {
			System.out.println("No product found:"+N);
		}
	}
	public void add_amount(String N,int A) {
		if(this.name.equals(N)) {
			System.out.println("product:"+N+" add amount:"+A);
			this.amount+=A;
			System.out.println("This product is currently in stock for:"+this.amount);
		}else {
			System.out.println("No product found:"+N);

		}
	}
	public void reduce_amount(String N,int A) {
		if(this.name.equals(N)) {
			if(A>this.amount) {
				System.out.println("The inventory quantity is less than the quantity to be reduced");
			}else {
				this.amount-=A;
				System.out.println("This product is currently in stock for:"+this.amount);
			}
		}else {
			System.out.println("No product found:"+N);
		}
	}
	public void total(String N) {
		if(this.name.equals(N)) {
			System.out.println("Total price is: "+this.amount*this.price+" dollars");
		}else {
			System.out.println("No product found:"+N);
		}
	}
	private String name;
	private int amount,price;
}
public class homework1{
	public static void main(String args[]) {
		Inventory DrinkShop = new Inventory("green tea",5,30);
		Inventory Product_3C = new Inventory("IPhone",3,3000);
		
		DrinkShop.add_product("black tea", 3, 25);
		Product_3C.add_product("Android",6,1500);
		
		DrinkShop.reduce_product("green tea");
		Product_3C.reduce_product("Samsung");
		
		DrinkShop.add_amount("green tea", 5);
		Product_3C.add_amount("OPPO", 3);
		
		DrinkShop.reduce_amount("green tea", 3);
		Product_3C.reduce_amount("Android", 7);
		
		DrinkShop.total("green tea");
		DrinkShop.total("black tea");
		Product_3C.total("IPhone");
		Product_3C.total("Android");
		Product_3C.total("Samsung");
		Product_3C.total("OPPO");
	}
}