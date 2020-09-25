import java.util.*;

public class PlacingParentheses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }

    private static long getMaximValue(String exp) {
        List<Long> nums = new ArrayList<>(exp.length() / 2);
        List<String> ops = new ArrayList<>(exp.length() / 2);

        int i = 0;
        for (i=0;i < exp.length();i++) {
            nums.add(Long.parseLong("" + exp.charAt(i)));
            if (i < exp.length() - 1) {
                i++;
                ops.add("" + exp.charAt(i));
            }
        }

        if (nums.size() == 1) {
            return nums.get(0);
        }
        long [][] MAX = new long[nums.size()][nums.size()];
        long [][] MIN = new long[nums.size()][nums.size()];

        for (i = 0; i < nums.size(); i++) {
            for (int j = 0; j <nums.size(); j++) {
                MAX[i][j] = Integer.MIN_VALUE;
                MIN[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int l = 1; l <= nums.size(); l++) {
            for (i = 0; i<= nums.size() - l; i++) {
                int j = i + l - 1;
                if (i == j) {
                    MAX[i][j] = nums.get(i);
                    MIN[i][j] = nums.get(i);
                }
                else {
                    int k = i;
                    while (k<j) {
                        if (ops.get(k).equalsIgnoreCase("+")) {
                            MAX[i][j] = Math.max(MAX[i][j], MAX[i][k] + MAX[k+1][j]);
                            MIN[i][j] = Math.min(MIN[i][j], MIN[i][k] + MIN[k+1][j]);
                        }
                        else if (ops.get(k).equalsIgnoreCase("*")) {
                            long a = MAX[i][k] * MAX[k+1][j];
                            long b = MAX[i][k] * MIN[k+1][j];
                            long c = MIN[i][k] * MAX[k+1][j];
                            long d = MIN[i][k] * MIN[k+1][j];

                            MAX[i][j] = max(MAX[i][j], a,b,c,d);
                            MIN[i][j] = min(MIN[i][j], a,b,c,d);

                        }
                        else if (ops.get(k).equalsIgnoreCase("-")) {
                            MAX[i][j] = Math.max(MAX[i][j], MAX[i][k] - MIN[k+1][j]);
                            MIN[i][j] = Math.min(MIN[i][j], MIN[i][k] - MAX[k+1][j]);
                        }
                        k++;
                    }
                }
            }
        }
        return MAX[0][nums.size() - 1];
    }

    public static long min(long ...arr) {
        long result = arr[0];
        for (int i = 1; i< arr.length; i++){
            result = Math.min(result, arr[i]);
        }
        return result;
    }

    public static long max(long ...arr) {
        long result = arr[0];
        for (int i = 1; i< arr.length; i++){
            result = Math.max(result, arr[i]);
        }
        return result;
    }
}

