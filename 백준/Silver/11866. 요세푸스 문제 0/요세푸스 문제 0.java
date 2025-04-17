import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            q.offer(i);
        }

        int[] arr = new int[N];
        int idx = 0;
        while(!q.isEmpty()){
            for(int  i = 0 ; i < K-1 ; i++){
                q.offer(q.poll());
            }
            arr[idx++] = q.poll();
        }
        System.out.print("<");

        for(int i = 0 ; i < N ; i++){
            if(i != arr.length -1){
                System.out.print(arr[i] + ", ");
            }
            else {
                System.out.print(arr[i]);
            }
        }                
        System.out.print(">");

    }
}
