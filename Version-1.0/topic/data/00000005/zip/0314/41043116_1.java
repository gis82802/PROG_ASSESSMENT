import java.util.Scanner;
class Inventory
{
    public String name=" ";
    public int number;
    public int price;
    public Inventory()
    {
        name=" ";number=0;price=0;
    }
    public void add_n(String n,int num,int p)
    {
        name=n;number=num;price=p;
    }
    public void add(int num)
    {
        number+=num;
    }
    public void sub_n()
    {
        name=" ";number=0;price=0;
    }
    public int count(int num,int price)
    {
        return(num*price);
    }
}
public class java12231 {
    public static void main(String args[])
    {
        Inventory c3[]=new Inventory[20];
        Inventory c4[]=new Inventory[20];
        for (int i=0;i<20;i++)
        {
            c3[i]=new Inventory();
            c4[i]=new Inventory();
        }
        Scanner Scn = new Scanner(System.in);int in,in2;String ns;
        while(true)
        {
            System.out.println("選擇店 1:3c.2:飲料店");
            int a=Scn.nextInt();
            System.out.println("操作:1:新增/刪除商品,2:更改數量,3:計算價值");
            if(a==1)
            {
                a=Scn.nextInt();
                if(a==1)
                {
                    System.out.println("操作:1:新增,2:刪除商品");
                    a=Scn.nextInt();
                    System.out.println("請輸入名稱:");
                    ns=Scn.next();
                    for(int i=0;i<20;i++)
                    {
                        if(a==1)
                        {
                            if(c3[i].name == " ")
                            {
                                System.out.println("abbbaa:");
                                System.out.println("請輸入數量:");
                                in=Scn.nextInt();
                                System.out.println("請輸入價格:");
                                in2=Scn.nextInt();
                                c3[i].add_n(ns,in,in2);
                                break;
                            }
                        }else
                        {
                            if(c3[i].name == ns)
                            {
                                c3[i].sub_n();
                                break;
                            }
                        }
                        
                    } 

                }else if(a==2)
                {
                    System.out.println("請輸入名稱:");
                    ns=Scn.next();
                    for(int i=0;i<20;i++)
                    {
                        if(c3[i].name == ns)
                        {
                            System.out.println("請輸入數量:");
                            in=Scn.nextInt();
                            c3[i].add(in);
                            break;
                        }
                    } 
                }else if(a==3)
                {
                    int total=0;
                    for(int i=0;i<20;i++)
                    {
                        if(c3[i].name != " ")
                        {
                            total+=c3[i].count(c3[i].number, c3[i].price);
                            
                          
                        }
                    } 
                    System.out.println(total);
                }
            }else
            {
                a=Scn.nextInt();
                if(a==1)
                {
                    System.out.println("操作:1:新增,2:刪除商品");
                    a=Scn.nextInt();
                    System.out.println("請輸入名稱:");
                    ns=Scn.next();
                    for(int i=0;i<20;i++)
                    {
                        if(a==1)
                        {
                            if(c4[i].name == " ")
                            {
                                System.out.println("請輸入數量:");
                                in=Scn.nextInt();
                                System.out.println("請輸入價格:");
                                in2=Scn.nextInt();
                                c4[i].add_n(ns,in,in2);
                                break;
                            }
                        }else
                        {
                            if(c4[i].name == ns)
                            {
                                c4[i].sub_n();
                                break;
                            }
                        }
                        
                    } 

                }else if(a==2)
                {
                    System.out.println("請輸入名稱:");
                    ns=Scn.next();
                    for(int i=0;i<20;i++)
                    {
                        if(c4[i].name == ns)
                        {
                            System.out.println("請輸入數量:");
                            in=Scn.nextInt();
                            c4[i].add(in);
                            break;
                        }
                    } 
                }else if(a==3)
                {
                    int total=0;
                    for(int i=0;i<20;i++)
                    {
                        if(c4[i].name != " ")
                        {
                            total+=c4[i].count(c4[i].number, c4[i].price);;
                            
                            
                        }
                    } 
                    System.out.println(total);
                }

            }
        }
        
    }
}
