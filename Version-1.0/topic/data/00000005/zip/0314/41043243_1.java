/*
	INFO:
	----------------------------------------
	FILE NAME:	hw20230314_1.java
	FUNCTION:	建立一個類別 "Inventory"(庫存) 具有屬性像是：產品名稱、數量、價格，
				並且提供成員函式可以讓使用者新增產品、減少產品、新增數量、減少數量、以及計算整個庫存的價值。
				在主程式中建立二個庫存物件，分別給飲料店、以及3C手機店可以記錄其庫存。
	AUTHOR(S):	41043243
	VERSION:	1.0
	----------------------------------------
*/
import java.util.Arrays;

class Inventory{
	private String	ProductName[];
	private int		ProductStocks[];
	private int		ProductPrice[];

	private int		ProductIndex;
	
	public Inventory(){
		ProductName 	= new String[8];
		ProductStocks	= new int[8];
		ProductPrice	= new int[8];
		System.out.println("[INFO] Inventory constructor called.");
	}

	public Inventory(int size){
		ProductName 	= new String[size];
		ProductStocks	= new int[size];
		ProductPrice	= new int[size];
		System.out.println("[INFO] Inventory constructor called.");
	}

	public void LaunchProduct(String Name, int Stocks, int Price){
		if (ProductIndex + 1 >= ProductName.length){
			ProductName		= Arrays.copyOf(ProductName,	ProductName.length * 2);
			ProductStocks	= Arrays.copyOf(ProductStocks,	ProductStocks.length * 2);
			ProductPrice	= Arrays.copyOf(ProductPrice,	ProductPrice.length	* 2);
			System.out.println("[INFO] Extended Array Size.");
		}
		ProductName[ProductIndex]	= Name;
		ProductStocks[ProductIndex]	= Stocks;
		ProductPrice[ProductIndex]	= Price;

		ProductIndex++;
		System.out.println("[INFO] Launched product '" + Name + "'.");
	}

	public void RemoveProduct(String Name){
		int targetIndex = CheckProductAvailable(Name);
		if (targetIndex != -1){
			for (int i = targetIndex; i < ProductIndex; i++){
				ProductName[i]		= ProductName[i + 1];
				ProductStocks[i]	= ProductStocks[i + 1];
				ProductPrice[i]		= ProductPrice[i + 1];
			}
			ProductIndex--;
			System.out.println("[INFO] Removed product '" + Name + "'.");
		}
	}

	public int OverallBalance(){
		int balance = 0;
		for (int i = 0; i < ProductIndex; i++)
			balance += ProductPrice[i] * ProductStocks[i];
		return balance;
	}

	public void ListProducts(){
		System.out.println("--------------");
		System.out.println("Product list:");
		System.out.println("Name\tStocks\tPrice");
		for (int i = 0; i < ProductIndex; i++)
			System.out.println(ProductName[i] + "\t" + ProductStocks[i] + "\t" + ProductPrice[i]);
		System.out.println("--------------");
	}

	public void ChangeStock(String Name, int stocks){
		int targetIndex = CheckProductAvailable(Name);
		if (targetIndex != -1){
			ProductStocks[targetIndex] += stocks;
			System.out.println("[INFO] Changed product '" + Name + "' stocks.");
		}
	}

	private int CheckProductAvailable(String Name){
		for (int targetIndex = 0; targetIndex < ProductIndex ; targetIndex++)
			if (Name == ProductName[targetIndex]) return targetIndex;
		System.out.println("[ERROR] Product '" + Name + "' not found.");
		return -1;
	}
}

public class hw20230314_1{
	public static void main(String args[]){
		Inventory DrinkShop = new Inventory();
		DrinkShop.LaunchProduct("Milk Tea", 100, 25);
		DrinkShop.LaunchProduct("Black Tea", 100, 20);
		DrinkShop.LaunchProduct("Green Tea", 100, 20);
		DrinkShop.LaunchProduct("Suspectious drink", 1, 50);
		DrinkShop.ChangeStock("Milk Tea", -50);
		DrinkShop.ChangeStock("Green Tea", 30);
		DrinkShop.RemoveProduct("Suspectious drink");
		DrinkShop.ChangeStock("Suspectious drink", 1);
		DrinkShop.ListProducts();
		System.out.println("Total Balance: " + DrinkShop.OverallBalance());

		Inventory ElectronicShop = new Inventory(4);
		ElectronicShop.LaunchProduct("Fan", 20, 300);
		ElectronicShop.LaunchProduct("Heater", 10, 1000);
		ElectronicShop.LaunchProduct("Television", 10, 25000);
		ElectronicShop.LaunchProduct("Refridgeator", 5, 15000);
		ElectronicShop.LaunchProduct("Monitor", 30, 4500);
		ElectronicShop.LaunchProduct("Vacumm", 15, 3500);
		ElectronicShop.LaunchProduct("Custom Order", 1, 15000);
		ElectronicShop.ChangeStock("Fan", -15);
		ElectronicShop.ChangeStock("Vacumm", -5);
		ElectronicShop.ChangeStock("Monitor", 5);
		ElectronicShop.RemoveProduct("Custom Order");
		ElectronicShop.ListProducts();
		System.out.println("Total Balance: " + ElectronicShop.OverallBalance());
	}
}