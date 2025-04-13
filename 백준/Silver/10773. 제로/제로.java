import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<Integer>();
        Integer N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                stack.pop();
            }
            else {
                stack.push(n);
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.peek();
            stack.pop();
        }
        System.out.println(sum);
    }
}