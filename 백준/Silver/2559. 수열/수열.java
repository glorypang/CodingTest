import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i =1 ; i <= N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int[] sum = new int[N+1];
        for(int i =1 ; i <= N; i++)
            sum[i] = sum[i-1]+arr[i];
        
        int max = Integer.MIN_VALUE;
        for(int i = K; i <= N; i++)
            max = Math.max(max, sum[i] - sum[i-K]);
        System.out.println(max);
    }
}
