import java.util.*;
import java.util.stream.Collectors;


public class LargestNumber {
    static void printLargest(Vector<String> arr){

        arr.sort((X, Y) -> {
            String XY = X + Y;
            String YX = Y + X;
            if(XY.equals(YX)){
                return 0;
            }
            return XY.compareTo(YX) > 0 ? -1 : 1;
        });

        for (String s : arr) System.out.print(s);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vector<String> arr = new Vector<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            arr.add(scanner.next());
        }
        printLargest(arr);
    }
}

