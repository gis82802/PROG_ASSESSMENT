/*
	filename:Java_0927_02
	function:���઺�ϱ׽u
	author:���ʫ� 40943212
	datetime:2024/09/27
	version:1.0
*/

public class Java_0927_02 {
    public static void main(String[] args) throws InterruptedException {
        // ���઺�Ÿ��C��
        char[] spinChars = {'|', '/', '-', '\\'};
        
        // �L���j�����������B��
        while (true) {
            for (char c : spinChars) {
                // �ϥ� \r �^��歺�A�M�� print �s���Ÿ�
                System.out.print("\r" + c);
                // �Ȱ� 200 �@��A�ϱ���i��
                Thread.sleep(200);
            }
        }
    }
}

