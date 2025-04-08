import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int[] arr = new int[input.length + 1];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        int start = 0;
        int end = 0;
        int cnt =0;
        while((N) != start){
            int sum = 0;

            for(int i = start; i <= end; i++){
                sum += arr[i];
            }
           // System.out.println(start + ", " + end + "=" + sum+ " " + cnt);

            if(end != N-1){
                if(sum == M) {
                    cnt++;
                    end++;
                }
                else if(sum > M) start++;
                else end++;
            }
            else{
                if(sum == M) {
                    cnt++;
                    start++;
                }
                else  start++;
            }

        }
        System.out.println(cnt);
    }
}