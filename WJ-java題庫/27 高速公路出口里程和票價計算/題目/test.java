public class test {

    public static double calculatePrice(int distance) {
        if (distance <= 50) {
            return distance * 2.5;
        } else if (distance <= 200) {
            return distance * 2.2;
        } else {
            return distance * 2.0;
        }
    }

    public static void main(String[] args) {
        String[] cities = {"台北", "桃園", "新竹", "台中", "嘉義", "台南", "高雄"};
        int[] mileages = {25, 49, 95, 178, 264, 327, 373};
        int numCities = cities.length;

        // 印出里程表
        System.out.print("哩程表  ");
        for (String city : cities) {
            System.out.printf("%6s", city);
        }
        System.out.println();

        for (int i = 0; i < numCities; i++) {
            System.out.printf("%4s", cities[i]);
            for (int j = 0; j < numCities; j++) {
                int distance = Math.abs(mileages[i] - mileages[j]);
                System.out.printf("%6d", distance);
            }
            System.out.println();
        }

        System.out.println();

        // 印出票價表
        System.out.print("票價表  ");
        for (String city : cities) {
            System.out.printf("%6s", city);
        }
        System.out.println();

        for (int i = 0; i < numCities; i++) {
            System.out.printf("%4s", cities[i]);
            for (int j = 0; j < numCities; j++) {
                int distance = Math.abs(mileages[i] - mileages[j]);
                int price = (int) Math.round(calculatePrice(distance));
                System.out.printf("%6d", price);
            }
            System.out.println();
        }
    }
}