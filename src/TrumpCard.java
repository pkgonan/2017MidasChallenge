import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TrumpCard {
    static String[] before, after;
    static boolean[] check;
    static int LENGTH = 0;

    public static void main(String[] args) throws IOException{
        init();
        ArrayList<String> arr = new ArrayList<>();
        DFS(0, arr);
        System.out.println(LENGTH);
    }

    static void DFS(int idx, ArrayList<String> arr){
        if(isPromising(arr, before) && isPromising(arr, after)) {
            LENGTH = Math.max(LENGTH, arr.size());
        }
        for(int i=idx; i<13; i++) {
            if (!check[i]) {
                check[i] = true;
                arr.add(before[i]);
                if(i+1 < 13) DFS(i + 1, arr);
                arr.remove(arr.size() - 1);
                check[i] = false;
            }
        }
    }

    static boolean isPromising(ArrayList<String> arr, String[] target){
        int maxIdx = 0;
        boolean found = false;
        for(int i=0; i<arr.size(); i++){
            found = false;
            for(int j=maxIdx; j<13; j++){
                if(arr.get(i).equals(target[j])) {
                    if(maxIdx <= j) {
                        maxIdx = j;
                        found = true;
                        break;
                    }
                    else return false;
                }
            }
            if(!found) return false;
        }
        return true;
    }

    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringTokenizer stt = new StringTokenizer(br.readLine(), " ");
        before = new String[13];
        after = new String[13];
        check = new boolean[13];
        for(int i=0; i<13; i++){
            before[i] = st.nextToken();
            after[i] = stt.nextToken();
        }
    }
}