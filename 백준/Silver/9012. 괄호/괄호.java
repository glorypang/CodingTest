import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < n ; i++) {
            Stack<Character> stack = new Stack<>();
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for(char c : s.toCharArray()) {
                if(stack.isEmpty())
                    stack.push(c);
                else {
                    if(c == '(')
                        stack.push(c);
                    else{
                        if(stack.peek() == '(')
                            stack.pop();
                    }
                }
            }
            if(stack.isEmpty()) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
