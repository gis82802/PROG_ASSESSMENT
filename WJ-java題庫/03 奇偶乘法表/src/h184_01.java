class b{
    public static void main(String[] args) {
        for(int i=1;i<=9;i++){
            if (i%2==0){
                continue;
            }
            for (int j=1;j<=9;j++){
                if (j%2!=0){
                    continue;
                }
                if(j==8){
                    System.out.print(i+"*"+j+"="+(i*j));
                }else{
                    System.out.print(i+"*"+j+"="+(i*j)+"\t");
                }
            }
            System.out.println();
        }
    }
}
