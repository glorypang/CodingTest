import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[]input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int[] arr = new int[input.length+1];
        for (int i = 0; i< input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int cnt = 0;
        int start = 0;
        int end = 0;
        int sum = 0;

        while(true){

            if(sum < M) {
                if(end > N) break;
                sum += arr[end++];
            }
            else if(sum == M) {
                cnt++;
                sum -= arr[start++];

            }
            else {
                sum -= arr[start++];
            }
            //System.out.println("after " + start + ", " + end + ", " + sum );
            //System.out.println("----------------------------" );

            //if(start == N-1 && start == end) break;
        }

        System.out.println(cnt);
    }

}