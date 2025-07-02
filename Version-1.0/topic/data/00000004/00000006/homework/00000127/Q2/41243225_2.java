import java.util.Scanner;
public class b {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String x=new String(input.nextLine());
        boolean flag=false;
        input.close();int j=0;
        for (char i: x.toCharArray()) {
            if(j>i){flag=true;break;}
            j=i;
        }System.out.println(flag?"is not well-order number":"is well-order number");

        int c=0;
        for(int i=0;i<100000;i++){
            for (char k: Integer.toString(i).toCharArray()) {
                if(k>i){continue;}
c++;
            }}
            System.out.println(c);
    }
}
