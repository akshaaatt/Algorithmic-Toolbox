import java.util.Scanner;

public class CarFueling {
    static int computeMinRefills(int d, int tank, int[] stops, int n) {
        int start = 0, end = 0, count = 0, i = 0;
        int lind = n;
        if (tank >= d) {
            return 0;
        }
        while (start < d) {
            int check = 0;
            while (i < n && (stops[i] - start) <= tank) {
                end = stops[i];
                i++;
                check++;
            }
            if (end == stops[lind - 1]) {
                if (d - start <= tank) {
                    return count;
                }
                else {
                    if(d-end>tank) {
                        return -1;
                    }
                }
            }
            if (check == 0) {
                return -1;
            }
            else {
                count++;
                start = end;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int[] stops = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }
        System.out.println(computeMinRefills(dist, tank, stops,n));
    }
}
