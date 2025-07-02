/*author:41043122狶グ琑
  date:03/14
  function:ミ畐
	*/
public class work3141
{
	public static void main(String args[])
	{
		Inventory drink=new Inventory();		//都┍
		Inventory phone=new Inventory();		//も诀┍


		Inventory blacktea=new Inventory("blacktea",10,20);	//
		Inventory bubbletea=new Inventory("bubbletea",15,30);	//イ
		Inventory samsung=new Inventory("samsung",100,750);	//琍
		Inventory iphone=new Inventory("iphone",120,1000);	//墨狦
		
		drink.addprod(blacktea);
		drink.addprod(bubbletea);
		phone.addprod(samsung);
		phone.addprod(iphone);
		

		System.out.println("都┍畐:");
		drink.invdisplay();
		System.out.println("も诀┍畐:");
		phone.invdisplay();
		System.out.println("都┍畐羆基:"+drink.totalvalue());
		System.out.println("も诀┍畐羆基:"+phone.totalvalue());

		System.out.println("埃iphone");
		phone.subprod(iphone);
		System.out.println("も诀┍畐:");
		phone.invdisplay();
	}
}
class Inventory
{
	String name;
	int quan;
	int price;

	Inventory inv[]=new Inventory[100];

	int flag=0;
	public Inventory(String a,int b,int c)
	{

		this.name=a;
		this.quan=b;
		this.price=c;
	}
	public Inventory()
	{
		Inventory inv[];
		inv=new Inventory[100];
		this.name=" ";
		this.quan=0;
		this.price=0;
	}
	public void addprod(Inventory a)
	{	
		inv[flag]=a;
		flag++;
	}
	public void subprod(Inventory a)
	{	
		for(int i=0;i<flag;i++)
		{
			if(inv[i].name==a.name)
			{
				inv[i].quan=0;
				inv[i].name=" ";
				inv[i].price=0;
			}
		}
		;
	}
	public void subquan(Inventory a,int b)
	{	
		for(int i=0;i<flag;i++)
		{
			if(inv[i].name==a.name)
			{
				inv[i].quan=inv[i].quan-b;
			}
		}
	}
	public void addquan(Inventory a,int b)
	{	
		for(int i=0;i<flag;i++)
		{
			if(inv[i].name==a.name)
			{
				inv[i].quan=inv[i].quan+b;
			}
		}
	}
	public void invdisplay()
	{
		for(int i=0;i<flag;i++)
		{
			if(inv[i].name!=" ")
				System.out.println(inv[i].name+"计秖="+inv[i].quan+"基窥="+inv[i].price);
		}
	}
	public int totalvalue()
	{
		int total=0;
		for(int i=0;i<flag;i++)
		{
			
			total=total+(inv[i].price*inv[i].quan);
			
		}
		return(total);
	}	
	
}