package Task.Fibonacci.FibonacciLast10;

import java.util.Scanner;

public class FibonacciLast {
    public static void main(String[] args) {

        Scanner fib = new Scanner(System.in);
        int n = fib.nextInt();
        int FibN = 0;
        int a = 0;
        int[] arrayFib = new int [n + 1];

        if ((n == 0) || (n == 1))
            System.out.println(n);

        else {
            arrayFib[0] = 0;
            arrayFib[1] = 1;
            for (int i = 2; i <= n; i++) {
                arrayFib[i] = ( arrayFib[i - 1] + arrayFib[i - 2] ) % 10;
                if (i == n) {
                    FibN = arrayFib[n];
                }
            }
            String FibRes = String.valueOf(FibN);
            System.out.println(FibRes);
        }
    }
}
