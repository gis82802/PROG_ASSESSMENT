import java.util.Scanner;
public class hw3{
    public static void main(String[] args){
        int iinput,itest,ia=0;
        Scanner scn=new Scanner(System.in);
        System.out.print("�п�J�@��Ʀr:");
        iinput=scn.nextInt();
        itest=iinput;     //�N������t�@�ܼƨϥ�
        System.out.printf("%d->",iinput);
        int i=0;
        while(itest!=0){    //�p����
            itest=itest/10;
            i++;
        }
        i-=1;
        itest=iinput;
        while(itest!=0){    //�@��@���J�A�ϦV��X
            ia+=(itest%10)*Math.pow(10,i);    //�N��J�B�z�ۥ[
            itest=itest/10;
            i--;
        }   
        System.out.printf("%d",ia);
    }
}