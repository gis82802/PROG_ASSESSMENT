/*
	filename:Java_0927_01
	function:�C�L�m�W��Unicode
	author:���ʫ� 40943212
	datetime:2024/09/27
	version:1.0
*/

public class Java_0927_01
{
	public static void main(String arg[])
	{
		String name = "���ʫ� ��ߪ����ޤj�� ��T�u�{�t";
		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);  // ���o�r��
			int unicode = (int) c;    // ���o�r����Unicode��
			System.out.print(c + " ( " + unicode + " ) " );  // ��X�r���Ψ�Unicode��
		}
	}
}
