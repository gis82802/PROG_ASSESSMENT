package inventory;
import java.util.ArrayList;
import java.util.Scanner;

//inventory
//庫存類別
//呂昱諦
//1.0

public class CW1
{
	public static void main(String[] args) 
	{
		Scanner scn = new Scanner(System.in);
		inventory beverage_shop = new inventory();
		inventory cellphone_shop = new inventory();

		beverage_shop.add_product("蘋果汁", 10, 25);
		beverage_shop.products_list();
		beverage_shop.add_quantity(1, 20);
		beverage_shop.reduce_quantity(1, 10);
		beverage_shop.prices_sum();
		beverage_shop.product_overview();
		beverage_shop.delete_product(1);
		
		cellphone_shop.add_product("蘋果汁", 10, 25);
		cellphone_shop.products_list();
		cellphone_shop.add_quantity(1, 20);
		cellphone_shop.reduce_quantity(1, 10);
		cellphone_shop.prices_sum();
		cellphone_shop.product_overview();
		cellphone_shop.delete_product(1);
		
		/*while (true) 
		{
			System.out.println("選擇店面(飲料店:1, 手機電:2, 退出:0)");
			int shop = scn.nextInt();
			if(shop == 0)
				break;
			else
			{
				while(true)
				{
					System.out.println("選擇動作(新增產品:1, 刪除產品:2, 新增數量:3, 減少數量:4, 查看庫存:5, 庫存總價值:6, 退出:0)");
					int action = scn.nextInt();
					if(shop == 1)
					{
						if(action == 0)
							break;
						else if(action == 1)
						{
							System.out.println("請依序輸入產品名稱、數量、價格");
							System.out.print("產品名稱:");
							scn.nextLine();
							String name = scn.nextLine();
							System.out.print("數量:");
							int quantity = scn.nextInt();
							System.out.print("價格:");
							int price = scn.nextInt();
							beverage_shop.add_product(name, quantity, price);
						}
						else if(action == 2)
						{
							System.out.println("現有產品列表:");
							beverage_shop.products_list();
							System.out.print("請輸入要刪除的產品編號:");
							int index = scn.nextInt();
							beverage_shop.delete_product(index-1);
						}
						else if(action == 3)
						{
							System.out.println("現有產品列表:");
							beverage_shop.products_list();
							System.out.print("請輸入要新增數量的產品名稱:");
							int index = scn.nextInt();
							System.out.print("新增數量:");
							int n = scn.nextInt();
							beverage_shop.add_quantity(index-1, n);
						}
						else if(action == 4)
						{
							System.out.println("現有產品列表:");
							beverage_shop.products_list();
							System.out.print("請輸入要減少數量的產品名稱:");
							int index = scn.nextInt();
							System.out.print("減少數量:");
							int n = scn.nextInt();
							beverage_shop.reduce_quantity(index-1, n);
						}
						else if(action == 5)
						{
							beverage_shop.product_overview();
						}
						else if(action == 6)
						{
							System.out.print("現有產品的總價值為 ");
							int sum = beverage_shop.prices_sum();
							System.out.println(sum + " 元");
						}
					}
					else 
					{
						if(action == 0)
							break;
						else if(action == 1)
						{
							System.out.println("請依序輸入產品名稱、數量、價格");
							System.out.print("產品名稱:");
							scn.nextLine();
							String name = scn.nextLine();
							System.out.print("數量:");
							int quantity = scn.nextInt();
							System.out.print("價格:");
							int price = scn.nextInt();
							cellphone_shop.add_product(name, quantity, price);
						}
						else if(action == 2)
						{
							System.out.println("現有產品列表:");
							cellphone_shop.products_list();
							System.out.print("請輸入要刪除的產品名稱:");
							int index = scn.nextInt();
							cellphone_shop.delete_product(index-1);
						}
						else if(action == 3)
						{
							System.out.println("現有產品列表:");
							cellphone_shop.products_list();
							System.out.print("請輸入要新增數量的產品名稱:");
							int index = scn.nextInt();
							System.out.print("新增數量:");
							int n = scn.nextInt();
							cellphone_shop.add_quantity(index-1, n);
						}
						else if(action == 4)
						{
							System.out.println("現有產品列表:");
							cellphone_shop.products_list();
							System.out.print("請輸入要減少數量的產品名稱:");
							scn.nextLine();
							int index = scn.nextInt();
							System.out.print("減少數量:");
							int n = scn.nextInt();
							cellphone_shop.reduce_quantity(index, n);
						}
						else if(action == 5)
						{
							beverage_shop.product_overview();
						}
						else if(action == 6)
						{
							System.out.print("現有產品的總價值為 ");
							int sum = cellphone_shop.prices_sum();
							System.out.println(sum + " 元");
						}
					}
				}
			}			
		}
    	*/
	}
}
class inventory
{
	private ArrayList<String> product = new ArrayList<String>();
	private ArrayList<Integer> quantity = new ArrayList<Integer>();
	private ArrayList<Integer> price = new ArrayList<Integer>();

	public inventory(){}

	public void add_product(String n, int q, int p)
	{
		product.add(n);
		quantity.add(q);
		price.add(p);
	}

	public void delete_product(int index)
	{
		product.remove(index);
		quantity.remove(index);
		price.remove(index);
	}

	public void add_quantity(int index, int n)
	{
		quantity.set(index, quantity.get(index) + n);
	}

	public void reduce_quantity(int index, int n)
	{
		if(quantity.get(index) - n < 0)
			quantity.set(index, 0);
		else quantity.set(index, quantity.get(index) - n);
	}

	public int prices_sum()
	{
		int sum = 0;
		for(int i = 0;i < price.size();i++)
			sum += quantity.get(i) * price.get(i);
		return sum;
	}

	public void products_list()
	{
		for(int i = 0;i < product.size();i++)
			System.out.println((i+1) + ". " + product.get(i));
	}
	
	public void product_overview()
	{
		System.out.println("產品名稱　　數量　　價格");
		for(int i = 0;i < product.size();i++)
			System.out.println(product.get(i) + "　　" + quantity.get(i) + "　　" + price.get(i));
	}
}