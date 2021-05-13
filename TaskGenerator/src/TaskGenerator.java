import java.util.Scanner;
import java.lang.Math;

public class TaskGenerator {
    final int SUM = 0;
    final int SUB = 1;
    final int MUL = 2;
    final int DET = 3;
    MatrixAllFunc m;

    public double CheckFractionalNumber(String fractional) { //Обработка числа в дробном формате
        int slash = fractional.indexOf('/');
        double top = Double.parseDouble(fractional.substring(0, slash));
        double bot = Double.parseDouble(fractional.substring(slash + 1));
        return top / bot;
    }

    public double[][] MatrixGenerator(int n, int m) { //Создание и заполнение матрицы случайными числами
        double[][] A = new double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                A[i][j] = (int) (Math.random() * 21);
            }
        }
        return A;
    }

    public void MatrixOutput(double[][] A, boolean f) { //Вывод матрицы
        for (int i = 0; i < A.length; i++) {
            if (!f) {
                f = true;
            } else {
                System.out.print("\n");
            }
            for (int j = 0; j < A[0].length; j++) {
                System.out.printf("%1$-3s", (int) A[j][i]);
            }
        }
    }
}