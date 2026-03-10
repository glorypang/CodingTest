import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int l = 0;
        int r = 0;
        int len = Integer.MAX_VALUE;
        int total =0;
        while(true){
            if(total < M){
                if(r == N) break;
                total += arr[r++];
            }
            else if(total >= M){
                len = Math.min(len, r-l);
                total -= arr[l++];
            }
        }

        System.out.println(len == Integer.MAX_VALUE ? 0 : len);
    }
}
