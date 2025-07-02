class a {
    public static int[][] MatMultiply(int[][] a, int[][] b) {
        if (a.length != b[0].length || a[0].length != b.length) {
            return null;
        }
        int[][] c = new int[a.length][b[0].length];
        int k = 0, l = 0;
        for (int o = 0; o < a.length; o++) {
            for (int i = 0; i < b[0].length; i++) {
                int t = 0;
                for (int j = 0; j < b.length; j++) {
                    t += a[o][j] * b[j][i];
                    System.out.println(o + " " + j + " " + i + " " + a[o][j] + " " + b[j][i]);
                }
                c[k][l] = t;
                System.out.println(k+" "+l);
                l++;
                if (l > c[k].length-1) {
                    l = 0;
                    k++;
                }
            }
        }
        return c;
    }

    public static void main(String[] args) {
        int[][] a = { { 1, 0, 2 }, { -1, 3, 1 } };
        int[][] b = { { 3, 1 }, { 2, 1 }, { 1, 0 } };
        int[][] c = MatMultiply(a, b);
        for (int[] i : c) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}