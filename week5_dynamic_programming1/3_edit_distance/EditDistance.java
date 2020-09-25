import java.util.*;

class EditDistance {
    public static int EditDistance(String s, String t) {

        int [][] edit = new int[s.length() + 1][t.length() + 1];

        for (int i = 0; i <= s.length(); i++) {
            edit[i][0] = i;
        }

        for (int j = 0; j <= t.length(); j++) {
            edit[0][j] = j;
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <=t.length(); j++) {

                edit[i][j] = Integer.MAX_VALUE;
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    edit[i][j] = edit[i-1][j-1];
                }
                int substitution = edit[i-1][j-1] + 1;
                int insertion = edit[i][j-1] + 1;
                int deletion = edit[i-1][j] + 1;

                edit[i][j] = min(edit[i][j] , substitution, insertion, deletion);
            }
        }

        return edit[s.length()][t.length()];
    }

    public static int min(int ...arr) {
        int result = arr[0];
        for (int i = 1; i< arr.length; i++){
            result = Math.min(result, arr[i]);
        }
        return result;
    }
    
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
