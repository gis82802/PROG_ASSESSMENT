public class hw40643149_241011_1 {
    public static void main(String[] args) {
        int in;
        double pi = 0, i, PorM = 1;
        for(in = 1; in <= 10; in++){
            for(i = 1; i < in * 10000 + 1; i++){
                pi += (1 / ((2 * i) - 1)) * PorM;
                PorM *= -1;
            }
            pi *= 4f;
            System.out.println(pi);
            pi = 0;
        }
        int out;
        pi = 0; 
        PorM = 1;
        for(i = 1; ; i++){
            pi += (1 / ((2 * i) - 1)) * PorM;
            PorM *= -1;
            out = (int)Math.floor(pi * 400000f);
            if(out == 314159){
                System.out.println("i = " + i);
                break;
            }
        }
    }
}
