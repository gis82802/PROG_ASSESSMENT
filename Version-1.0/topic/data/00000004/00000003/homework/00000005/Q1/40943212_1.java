/*
	filename:Java_0927_02
	function:旋轉的反斜線
	author:陳廷威 40943212
	datetime:2024/09/27
	version:1.0
*/

public class Java_0927_02 {
    public static void main(String[] args) throws InterruptedException {
        // 旋轉的符號列表
        char[] spinChars = {'|', '/', '-', '\\'};
        
        // 無限迴圈讓旋轉持續運行
        while (true) {
            for (char c : spinChars) {
                // 使用 \r 回到行首，然後 print 新的符號
                System.out.print("\r" + c);
                // 暫停 200 毫秒，使旋轉可見
                Thread.sleep(200);
            }
        }
    }
}

