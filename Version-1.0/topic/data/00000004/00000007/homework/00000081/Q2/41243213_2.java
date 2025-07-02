import java.util.Scanner;

public class ReplaceWithGreatest {
    public static void replaceWithGreatest(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int max = -1; 

        for (int i = nums.length - 1; i >= 0; i--) {
            int current = nums[i]; 
            nums[i] = max;
            if (current > max) {
                max = current; 
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("enter the size: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        System.out.println("pleas enter " + n + " number:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        replaceWithGreatest(nums);

        System.out.println("result:");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}