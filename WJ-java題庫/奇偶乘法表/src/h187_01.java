public class ex2 {
        public static void main(String[] args) {
            for (int i=1;i<=9;i+=2){
              for(int j=2;j<=9;j+=2) {
                  
                  if (j==8) {
                      System.out.print(i+"*"+j+"="+(i*j));
                  } else {
                      System.out.print(i+"*"+j+"="+(i*j)+"\t");
                  }
                 
              }
              System.out.println();
            }
        }
      }

