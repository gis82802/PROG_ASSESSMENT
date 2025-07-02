public class test{
	public static void main(String args[]){
		System.out.println("國立虎尾科技大學資訊工程系林厚丞");
		String str = "國立虎尾科技大學資訊工程系";
		String s = "林厚丞";
		for(int i = 0; i < str.length(); i++){
			int uni;
			char c = str.charAt(i);
			uni = (int) c;
			System.out.print(str.charAt(i) + "(" + uni + ")");
		}
		System.out.println();
		for(int i = 0; i < s.length(); i++){
			System.out.print(s.charAt(i) + "(" + (int)s.charAt(i) + ")");
		}
	}
}