import java.io.*;
import java.util.*;


public class Main{
    static List<List<Integer>> list = new ArrayList<>();
    static int[] answer;
    static boolean[] visit;
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i<= N ;i++)
            list.add(new ArrayList<>());
        visit = new boolean[N+1];
        answer = new int[N+1];

        for(int i = 0; i < N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }
        bfs(1);

        for(int i = 2; i <= N; i++){
            System.out.println(answer[i]);
        }
    }
    public static void bfs(int n){
        Queue<Integer> q = new LinkedList<>();
        q.add(n);

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int next : list.get(cur)){
                if(!visit[next]){
                    answer[next] = cur;
                    visit[next] = true;
                    q.add(next);
                }
            }
        }
    }
}