import java.util.Scanner;

public class FibonacciLastDigit {

    static long fib(long num) {
        int pre=0,cur=1;
        num = num %60;
        if(num==0){
            return 0;}
        else if (num == 1){
            return 1;
        }
        else{
            for (int i =2; i<=num; i++){
                int temp = (pre+cur)%60;
                pre = cur;
                cur = temp;
            }
        }
        return(cur);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long a = fib(n);
        long b = fib(n+1);
        System.out.println((a*b)%10);
    }
}
