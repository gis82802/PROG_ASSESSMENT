import java.util.HashSet;
import java.util.Scanner;

public class test {

    public static boolean isPathCrossing(String path) {
        // 使用 HashSet 來儲存所有訪問過的位置，避免重複
        HashSet<String> visited = new HashSet<>();
        
        // 將起始點 (0, 0) 加入集合
        visited.add("0,0");

        int x = 0;
        int y = 0;

        for (char move : path.toCharArray()) {
            if (move == 'N') {
                y++;
            } else if (move == 'S') {
                y--;
            } else if (move == 'E') {
                x++;
            } else if (move == 'W') {
                x--;
            }

            String currentPosition = x + "," + y;
            
            // 如果當前位置已經在訪問過的集合中，表示路徑相交
            if (visited.contains(currentPosition)) {
                return true;
            }
            
            // 將新位置加入集合
            visited.add(currentPosition);
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //System.out.print("請輸入路徑字串: ");
        String path = scanner.nextLine();
        scanner.close();
        
        boolean result = isPathCrossing(path);
        System.out.println(result);
    }
}