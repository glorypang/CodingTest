import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        long[] sum = new long[N+1];
        long[] remain = new long[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < N ; i++)
            sum[i+1] = arr[i] + sum[i];

        for(long n: sum){
            remain[(int)(n % M)]++;
        }

        long cnt = 0;
        for (long n : remain) {
            cnt += n * (n - 1) / 2;
        }

        System.out.println(cnt);
    }
}
