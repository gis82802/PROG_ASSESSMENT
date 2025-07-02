class hw10182{
	public static void main(String[] args){
		int[] m={17,18,5,4,6,1};
		for(int i=0;i<m.length-1;i++){
			int a=m[i+1];
			for(int n=i+1;n<m.length-1;n++){
				if(a<m[n]) a=m[n];
			}
			m[i]=a;
		}
		m[m.length-1]=-1;
		System.out.print("[");
		for(int i=0;i<m.length;i++){
			System.out.print(m[i]);
			if(i==m.length-1) break;
			System.out.print(", ");
		}
		System.out.println("]");		
	}
}