import java.util.ArrayList;
import java.util.Scanner;

class MyStack {
    private ArrayList<Integer> stackList;

    public MyStack() {
        this.stackList = new ArrayList<Integer>();
    }

    // 將資料放入堆疊
    public void push(int item) {
        stackList.add(item);
        System.out.println("將 " + item + " 放入堆疊");
    }

    // 從堆疊取出資料
    public int pop() {
        if (stackList.isEmpty()) {
            System.out.println("堆疊為空，無法取出。");
            return -1;
        }
        int lastIndex = stackList.size() - 1;
        int item = stackList.remove(lastIndex);
        return item;
    }

    // 印出堆疊內容
    public void print() {
        System.out.print("堆疊內容: ");
        for (int i = 0; i < stackList.size(); i++) {
            System.out.print(stackList.get(i) + " ");
        }
        System.out.println();
    }
}

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyStack myStack = new MyStack();
        int item;

        //System.out.print("請輸入一系列整數 (以空格分隔，-1 結束): ");

        while ((item = scanner.nextInt()) != -1) {
            myStack.push(item);
        }
        scanner.close();

        System.out.println("從堆疊中取出: " + myStack.pop());
        System.out.println("從堆疊中取出: " + myStack.pop());
        
        myStack.print();
    }
}