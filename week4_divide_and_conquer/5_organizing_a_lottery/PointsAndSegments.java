import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class PointsAndSegments {

    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        Pair[] pairs=new Pair[starts.length*2+points.length];
        HashMap<Integer,ArrayList<Integer>> pointsMap= new HashMap<>();

        int i=0;
        for(int aux:starts)
            pairs[i++]=new Pair(aux,1);

        for(int aux:ends)
            pairs[i++]=new Pair(aux,3);

        for(int j=0; j<points.length; j++){
            int point=points[j];
            pairs[i++]=new Pair(point,2);
            if(pointsMap.containsKey(point)){
                pointsMap.get(point).add(j);
            }else{
                ArrayList<Integer> list= new ArrayList<>();
                list.add(j);
                pointsMap.put(point,list);
            }
        }

        Arrays.sort(pairs, (o1, o2) -> {
            if(o1.a==o2.a)
                return Integer.compare(o1.b, o2.b);
            return Integer.compare(o1.a, o2.a);
        });

        int coverage=0;
        for (Pair pair: pairs){
            if(pair.b==1)
                coverage++;
            else if(pair.b==3)
                coverage--;
            else {
                ArrayList<Integer> indexes=pointsMap.get(pair.a);
                for(Integer k:indexes){
                    cnt[k]=coverage;
                }
            }
        }
        return cnt;
    }

    private static class Pair {
        int a, b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        int[] cnt = fastCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}
