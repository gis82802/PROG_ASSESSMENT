// MyMatrix.java
class MyMatrix {
    private int rows, cols;
    private int[][] matrix;

    // 建構子，初始化矩陣大小
    public MyMatrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        matrix = new int[rows][cols];
    }

    // 設定矩陣值
    public void setMatrix(int[][] values) {
        if (values.length != rows || values[0].length != cols) {
            throw new IllegalArgumentException("Matrix dimensions do not match.");
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = values[i][j];
            }
        }
    }

    // 取得矩陣值
    public int[][] getMatrix() {
        return matrix;
    }

    // 印出矩陣
    public void printMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 矩陣加法
    public MyMatrix add(MyMatrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Matrix dimensions must match for addition.");
        }
        MyMatrix result = new MyMatrix(this.rows, this.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                result.matrix[i][j] = this.matrix[i][j] + other.matrix[i][j];
            }
        }
        return result;
    }

    // 矩陣減法
    public MyMatrix subtract(MyMatrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Matrix dimensions must match for subtraction.");
        }
        MyMatrix result = new MyMatrix(this.rows, this.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                result.matrix[i][j] = this.matrix[i][j] - other.matrix[i][j];
            }
        }
        return result;
    }

    // 矩陣乘法
    public MyMatrix multiply(MyMatrix other) {
        if (this.cols != other.rows) {
            throw new IllegalArgumentException("Matrix dimensions must match for multiplication.");
        }
        MyMatrix result = new MyMatrix(this.rows, other.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                for (int k = 0; k < this.cols; k++) {
                    result.matrix[i][j] += this.matrix[i][k] * other.matrix[k][j];
                }
            }
        }
        return result;
    }

    // 矩陣與純量的乘法
    public MyMatrix scalarMultiply(int scalar) {
        MyMatrix result = new MyMatrix(this.rows, this.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                result.matrix[i][j] = this.matrix[i][j] * scalar;
            }
        }
        return result;
    }
}

// 主程式
public class H11 {
    public static void main(String[] args) {
        // 建立兩個2x2矩陣
        MyMatrix matrix1 = new MyMatrix(2, 2);
        MyMatrix matrix2 = new MyMatrix(2, 2);

        // 設定矩陣1的值
        matrix1.setMatrix(new int[][]{{1, 2}, {3, 4}});
        // 設定矩陣2的值
        matrix2.setMatrix(new int[][]{{5, 6}, {7, 8}});

        // 印出矩陣1
        System.out.println("Matrix 1:");
        matrix1.printMatrix();

        // 印出矩陣2
        System.out.println("Matrix 2:");
        matrix2.printMatrix();

        // 矩陣加法
        System.out.println("Matrix 1 + Matrix 2:");
        MyMatrix resultAdd = matrix1.add(matrix2);
        resultAdd.printMatrix();

        // 矩陣減法
        System.out.println("Matrix 1 - Matrix 2:");
        MyMatrix resultSubtract = matrix1.subtract(matrix2);
        resultSubtract.printMatrix();

        // 矩陣乘法
        System.out.println("Matrix 1 * Matrix 2:");
        MyMatrix resultMultiply = matrix1.multiply(matrix2);
        resultMultiply.printMatrix();

        // 純量乘法
        int scalar = 2;
        System.out.println("Matrix 1 * Scalar " + scalar + ":");
        MyMatrix resultScalarMultiply = matrix1.scalarMultiply(scalar);
        resultScalarMultiply.printMatrix();

	System.out.println("Matrix 2 * Scalar " + scalar + ":");
        MyMatrix resultScalarMultiply2 = matrix2.scalarMultiply(scalar);
        resultScalarMultiply2.printMatrix();

    }
}
