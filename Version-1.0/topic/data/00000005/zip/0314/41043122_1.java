/*author:41043122�L���R
  date:03/14
  function:�إ߮w�s
	*/
public class work3141
{
	public static void main(String args[])
	{
		Inventory drink=new Inventory();		//���Ʃ�
		Inventory phone=new Inventory();		//�����


		Inventory blacktea=new Inventory("blacktea",10,20);	//����
		Inventory bubbletea=new Inventory("bubbletea",15,30);	//����
		Inventory samsung=new Inventory("samsung",100,750);	//�T�P
		Inventory iphone=new Inventory("iphone",120,1000);	//ī�G
		
		drink.addprod(blacktea);
		drink.addprod(bubbletea);
		phone.addprod(samsung);
		phone.addprod(iphone);
		

		System.out.println("���Ʃ��w�s:");
		drink.invdisplay();
		System.out.println("������w�s:");
		phone.invdisplay();
		System.out.println("���Ʃ��w�s�`���Ȭ�:"+drink.totalvalue());
		System.out.println("������w�s�`���Ȭ�:"+phone.totalvalue());

		System.out.println("�h��iphone");
		phone.subprod(iphone);
		System.out.println("������w�s:");
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
				System.out.println(inv[i].name+"�ƶq="+inv[i].quan+"����="+inv[i].price);
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