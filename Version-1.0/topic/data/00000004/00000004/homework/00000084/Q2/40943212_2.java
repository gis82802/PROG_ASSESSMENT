/*
	filename:Java_0927_01
	function:列印姓名及Unicode
	author:陳廷威 40943212
	datetime:2024/09/27
	version:1.0
*/

public class Java_0927_01
{
	public static void main(String arg[])
	{
		String name = "陳廷威 國立虎尾科技大學 資訊工程系";
		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);  // 取得字元
			int unicode = (int) c;    // 取得字元的Unicode值
			System.out.print(c + " ( " + unicode + " ) " );  // 輸出字元及其Unicode值
		}
	}
}
