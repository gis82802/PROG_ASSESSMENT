import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

// 抽象父類別 Bag
abstract class Bag {
    public abstract void push(int data);
    public abstract int pop();
    public abstract int top();
}

// Stack 類別
class StackBag extends Bag {
    private Stack<Integer> stack = new Stack<>();

    @Override
    public void push(int data) {
        stack.push(data);
        System.out.println("將資料 " + data + " 放入 Stack");
    }

    @Override
    public int pop() {
        return stack.pop();
    }

    @Override
    public int top() {
        return stack.peek();
    }
}

// Queue 類別
class QueueBag extends Bag {
    private Queue<Integer> queue = new LinkedList<>();

    @Override
    public void push(int data) {
        queue.add(data);
        System.out.println("將資料 " + data + " 放入 Queue");
    }

    @Override
    public int pop() {
        return queue.poll();
    }

    @Override
    public int top() {
        return queue.peek();
    }
}

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //System.out.print("請輸入一組整數 (以空格分隔，-1 結束): ");

        StackBag myStack = new StackBag();
        QueueBag myQueue = new QueueBag();
        int data;

        // 讀取輸入並將數字放入堆疊和隊列
        while ((data = scanner.nextInt()) != -1) {
            myStack.push(data);
            myQueue.push(data);
        }
        scanner.close();

        System.out.println("\nStack 功能展示：");
        System.out.println("Stack 頂部資料: " + myStack.top());
        System.out.println("從 Stack 取出資料: " + myStack.pop());
        System.out.println("Stack 頂部資料: " + myStack.top());
        System.out.println("從 Stack 取出資料: " + myStack.pop());
        System.out.println("從 Stack 取出資料: " + myStack.pop());

        System.out.println("\nQueue 功能展示：");
        System.out.println("Queue 頂部資料: " + myQueue.top());
        System.out.println("從 Queue 取出資料: " + myQueue.pop());
        System.out.println("Queue 頂部資料: " + myQueue.top());
        System.out.println("從 Queue 取出資料: " + myQueue.pop());
        System.out.println("從 Queue 取出資料: " + myQueue.pop());
    }
}