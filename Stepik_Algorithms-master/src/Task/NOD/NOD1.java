package Task.NOD;

import java.util.Scanner;

/**
 * Created by Nadezhda on 14.09.2017.
 */
public class NOD1 {
    public static void main(String[] args) {
        Scanner a1 = new Scanner(System.in);
        int a = a1.nextInt();
        int b = a1.nextInt();
        int r = 1;
        if (a == 0)
            System.out.println(b);
        if (b == 0)
            System.out.println(a);
        else {
            while (r != 0){
               r = a % b;
               a = b;
               b = r;
            }
            System.out.println(a);
        }
    }
}
