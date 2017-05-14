import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GatePassword {
    static int N,M,RESULT=0;
    static int[] arr;
    static boolean[] check;

    public static void main(String[] args) throws IOException{
        init();
        DFS(0,0);
        System.out.println(RESULT);
    }

    static void DFS(int num, int cnt){
        if(cnt==N){
            if(isPromising(num)) RESULT++;
            return;
        }
        else {
            for (int i=0; i<M; i++) {
                if(!check[i]){
                    check[i] = true;
                    DFS(num * 10 + arr[i], cnt+1);
                    check[i] = false;
                }
            }
        }
    }

    static boolean isPromising(int num){
        if(!isevenOrOdd(num)) return false;
        if(!isAsc(num)) return false;
        return true;
    }

    static boolean isevenOrOdd(int num){
        boolean evenCheck = false, oddCheck = false;

        int cnt = 0;
        while(num != 0){
            int tmp = num % 10;
            if(tmp % 2 == 0) evenCheck = true;
            if(tmp % 3 == 0) oddCheck = true;
            num /= 10;
            cnt++;
        }
        if(cnt == N-1) evenCheck = true;
        if(evenCheck && oddCheck) return true;
        else return false;
    }

    static boolean isAsc(int num){
        int MAX = Integer.MAX_VALUE;

        while(num != 0){
            int tmp = num % 10;
            if(MAX > tmp) MAX = tmp;
            else return false;
            num /= 10;
        }
        return true;
    }

    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<M; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        check = new boolean[11];
    }
}