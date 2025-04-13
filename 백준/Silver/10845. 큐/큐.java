import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        int last = -1;

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(s.equals("push")){
                int n = Integer.parseInt(st.nextToken());
                q.offer(n);
                last = n;
            }
            else if(s.equals("pop")){
                if(!q.isEmpty()){
                    System.out.println(q.poll());
                }
                else{
                    System.out.println(-1);
                }
            }
            else if(s.equals("size")){
                System.out.println(q.size());
            }
            else if(s.equals("empty")){
               System.out.println(q.isEmpty() ? 1: 0);
            }
            else if(s.equals("front")){
                System.out.println(q.isEmpty() ? -1: q.peek());
            }
            else if(s.equals("back")){
                System.out.println(q.isEmpty() ? -1: last);
            }
        }
    }
}