import java.util.Scanner;

public class PrimeSum {
    public static void main(String[] args){
        printResult();
    }

    static void printResult(){
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        boolean[] check = new boolean[N+1];
        if(N >= 0) check[0] = true;
        if(N >= 1) check[1] = true;
        int sum = 0;

        for(int i=2; i<=Math.sqrt(N); i++)
            for(int j=i+i; j<=N; j=j+i)
                check[j] = true;

        for(int i=M; i<=N; i++)
            if(!check[i]) sum += i;

        if(sum != 0) System.out.println(sum);
        else System.out.println(-1);
    }
}