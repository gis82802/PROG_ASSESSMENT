import java.util.Scanner;

class CircularQueue {
    private int[] queueArray;
    private int front;
    private int rear;
    private int capacity;
    private int currentSize;

    public CircularQueue(int size) {
        this.capacity = size;
        this.queueArray = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.currentSize = 0;
    }

    public boolean isFull() {
        return currentSize == capacity;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("錯誤：佇列已滿，無法放入。");
            return;
        }
        rear = (rear + 1) % capacity;
        queueArray[rear] = item;
        currentSize++;
        System.out.println("已放入: " + item);
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("錯誤：佇列為空，無法取出。");
            return -1; // 使用 -1 作為錯誤標記
        }
        int item = queueArray[front];
        front = (front + 1) % capacity;
        currentSize--;
        return item;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("錯誤：佇列為空，無法查看。");
            return -1; // 使用 -1 作為錯誤標記
        }
        return queueArray[front];
    }
    
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("佇列為空。");
            return;
        }
        System.out.print("目前佇列內容: ");
        for (int i = 0; i < currentSize; i++) {
            System.out.print(queueArray[(front + i) % capacity] + " ");
        }
        System.out.println();
    }
}

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //System.out.print("請輸入環狀佇列的大小: ");
        int size = scanner.nextInt();
        
        CircularQueue queue = new CircularQueue(size);
        System.out.println("環狀佇列已建立，大小為 " + size);
        
        int choice = 0;
        while (choice != -1) {
            //System.out.println("請選擇操作 (1:enqueue, 2:dequeue, 3:peek, 4:print, -1:結束): ");
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("輸入要放入的數字: ");
                    int item = scanner.nextInt();
                    queue.enqueue(item);
                    break;
                case 2:
                    int dequeuedItem = queue.dequeue();
                    if (dequeuedItem != -1) {
                        System.out.println("已取出: " + dequeuedItem);
                    }
                    break;
                case 3:
                    int peekItem = queue.peek();
                    if (peekItem != -1) {
                        System.out.println("佇列前端資料: " + peekItem);
                    }
                    break;
                case 4:
                    queue.printQueue();
                    break;
                case -1:
                    System.out.println("程式結束。");
                    break;
                default:
                    System.out.println("無效的選擇，請重新輸入。");
            }
        }
        scanner.close();
    }
}