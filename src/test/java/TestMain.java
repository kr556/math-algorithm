import com.algorithm.lang.print.Print;
import com.algorithm.math.Frac;
import com.algorithm.math.Matrix;

public class TestMain {
    public static void main(String[] args) {
        Matrix m1 = Matrix.identity(5);
        Matrix m2 = new Matrix(new double[][]{
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5}
        });

        Frac f1 = new Frac(0, 1);
        Frac f2 = new Frac(-1, 0);

        Print.frac(f1.adi(f2));
    }
}
