import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        float sum = 0;
        float max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            float num = Float.parseFloat(st.nextToken());
            max = Math.max(max, num);
            sum += num;
        }
        float result = (sum/max)*100/N;
        System.out.println(result);
    }
}