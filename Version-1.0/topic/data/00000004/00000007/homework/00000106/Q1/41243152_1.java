class hw10181{
	public static void main(String[] args){
		int[] m={65,16,23,56,5,45,3,74,36,10};
		System.out.print("排序前為：[");
		for (int i=0;i<m.length;i++) {
            		System.out.print(m[i]);
			if(i==m.length-1) break;
			System.out.print(", ");
        	}
		System.out.println("]");
		for (int i=0;i<m.length;i++) {
            		for(int n=0;n<m.length-1;n++){
				if(m[n]>m[n+1]){
					int a=m[n];
					m[n]=m[n+1];
					m[n+1]=a;
				}
			}
        	}
		System.out.print("排序後為：[");
		for (int i=0;i<m.length;i++) {
            		System.out.print(m[i]);
			if(i==m.length-1) break;
			System.out.print(", ");
        	}
		System.out.println("]");
	}
}