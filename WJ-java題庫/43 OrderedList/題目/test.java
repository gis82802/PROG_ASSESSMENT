import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class OrderedList {
    private ArrayList<Integer> list;

    public OrderedList() {
        this.list = new ArrayList<>();
    }

    public void add(int item) {
        list.add(item);
        // 插入後重新排序，或使用二分查找插入以保持排序
        Collections.sort(list);
    }

    public void print() {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public int find(int item) {
        // 使用 Collections.binarySearch 實現二分查找
        int index = Collections.binarySearch(list, item);
        return index >= 0 ? index : -1;
    }

    public void remove(int item) {
        list.remove(Integer.valueOf(item));
    }

    public void merge(OrderedList oL) {
        list.addAll(oL.list);
        Collections.sort(list);
    }
}

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderedList list1 = new OrderedList();
        OrderedList list2 = new OrderedList();
        int item;

        //System.out.println("請輸入要加入 list1 的數字 (以空格分隔，-1 結束): ");
        while ((item = scanner.nextInt()) != -1) {
            list1.add(item);
        }

        //System.out.println("請輸入要加入 list2 的數字 (以空格分隔，-1 結束): ");
        while ((item = scanner.nextInt()) != -1) {
            list2.add(item);
        }
        scanner.close();

        System.out.print("list1 的內容: ");
        list1.print();
        System.out.print("list2 的內容: ");
        list2.print();
        System.out.println();

        System.out.println("尋找數字 5：");
        int findResult1 = list1.find(5);
        if (findResult1 != -1) {
            System.out.println("數字 5 在 list1 中的位置是: " + findResult1);
        } else {
            System.out.println("數字 5 在 list1 中不存在。");
        }
        
        int findResult2 = list2.find(5);
        if (findResult2 != -1) {
            System.out.println("數字 5 在 list2 中的位置是: " + findResult2);
        } else {
            System.out.println("數字 5 在 list2 中不存在。");
        }

        System.out.println();
        list1.merge(list2);
        System.out.print("合併後 list1 的內容: ");
        list1.print();
    }
}