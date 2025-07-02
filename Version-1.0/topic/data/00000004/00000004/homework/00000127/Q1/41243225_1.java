public class Main {
  public static void main(String[] args) {
    char[] symbol={'|','/','-','\\'};
    while(true){
      for (int s=0;s<=3;s++) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println(symbol[s]);
        try{Thread.sleep(250);}catch(Exception e){};
      }
    }
  }
}