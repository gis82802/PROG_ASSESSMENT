public class app3_a
{
    public static void main (String args[]) 
    {
        int a[][]={{1,2,5},{3,4,6},{7,8,9}};
        int b[][]={{1,1,100},{1,100,1},{100,1,1}};
        int c[][];

        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<a[i].length;j++)
                System.out.print(a[i][j]+" ");
            System.out.println();
        }
        System.out.println();

        for(int i=0;i<b.length;i++)
        {
            for(int j=0;j<b[i].length;j++)
                System.out.print(b[i][j]+" ");
            System.out.println();
        }
        System.out.println();

        c=MatMultiply(a,b);

        for(int i=0;i<c.length;i++)
        {
            for(int j=0;j<c[i].length;j++)
                System.out.print(c[i][j]+" ");
            System.out.println();
        }
    }

    public static int[][] MatMultiply (int a[][],int b[][]) 
    {
        if(a[0].length!=b.length)
           return null;

        int c[][] = new int[a.length][b[0].length];

        for(int i=0;i<a.length;i++)
            for(int j=0;j<b[i].length;j++)
            {
                c[i][j]=0;
                for(int k=0;k<a[0].length;k++)
                c[i][j]+=a[i][k]*b[k][j];
            }
        return c;
    }
}