import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int start = 0;
        int end;
        int answer = 1;
        for (int i = 0; i < m; i++) {
            end = Integer.parseInt(br.readLine());
            answer *= fibo(end-start);
            //System.out.println(start + ", " + end + ", " + fibo(end-start));
            start = end;
        }
        answer *= fibo(n+1 - start);

        System.out.println(answer);
    }

    public static int fibo(int n){
        if(n <= 1)
            return n;
        else{
            return fibo(n-1) + fibo(n-2);
        }
    }
}