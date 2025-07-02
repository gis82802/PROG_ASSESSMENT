public class a {
    public static void main(String[] args) {
        double pi=1;
        double x=1;
        long i=2;
        while(true){
            x*=-1;
            pi+=(x/(2*i-1));
            if(i%10000==0 && i<=100001){
                System.out.println(i+":"+pi*4);
            }else{if((int)(400000*pi)==314159&&i>100000){System.out.println(i+":"+pi*4);break;}}
            i++;
        }
    }
}