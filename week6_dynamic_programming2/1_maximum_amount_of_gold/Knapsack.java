import java.util.*;

public class Knapsack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }

    static int optimalWeight(int W, int[] w) {
        int [][] MAX = new int [W + 1][w.length + 1];
        for (int weight = 0; weight <= W; weight++) {
            for (int i = 0; i<= w.length; i++) {
                if (i == 0 || weight == 0) {
                    MAX[weight][i] = 0;
                } else {
                    int dontUseIthItem = MAX[weight][i-1];
                    int useIthItem = Integer.MIN_VALUE;
                    if (weight - w[i-1] >= 0) {
                        useIthItem = MAX[weight - w[i-1]][i-1] + w[i-1];
                    }
                    MAX[weight][i] = Math.max(useIthItem, dontUseIthItem);
                }
            }
        }
        return MAX[W][w.length];
    }
}

