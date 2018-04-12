package Task.GreedyAlg;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Nadezhda on 15.09.2017.
 */
public class DifferentSum {
    public static void main(String[] args) {
        Scanner inN = new Scanner(System.in);
        int n = inN.nextInt();
        int count = 1;
        ArrayList<Integer> mas = new ArrayList<>();
        for (int i = 1; i <= n;) {
            if (i < n - i){
                mas.add(i);
                n = n - i;
                i++;
                count++;
            }
            else {
                mas.add(n);
                break;
            }
        }
        System.out.println(count);
        for (int i = 0; i < mas.size() ; i++) {
            System.out.print(mas.get(i) + " ");
        }
    }
}
