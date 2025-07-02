public class ex1
{
	public static void main(String args[])
	{
		String str = "虎尾科大資訊工程系黃詩方";
		for(int i=0; i<str.length(); i++)
		{
			char c = str.charAt(i); 
			int unicode = (int)c;
			String unicodeHex = "\\u" + Integer.toHexString(unicode);
			System.out.println(c + "("+ unicodeHex + ")");
		}
	}
}