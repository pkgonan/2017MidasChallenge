import java.util.*;

public class MidasNumber {
    static int N,M;

    public static void main(String[] args) {
        init();
        printResult();
    }

    static void printResult(){
        Set<Integer> set = new HashSet<>();

        for(int i=2; i<=Math.sqrt(N); i++)
            for(int j=i; j<N; j=j+i)
                set.add(j);

        System.out.println(set.size());
    }

    static void init(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
    }
}