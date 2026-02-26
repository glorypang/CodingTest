import java.io.*;
import java.util.*;

public class Main {
    public static List<List<Integer>> map = new ArrayList<>();
    public static boolean[] visit;
    public static int N;
    public static int M;
    public static int cnt = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        visit = new boolean[N+1];
        for(int i = 0; i <= N ; i++){
            map.add(new ArrayList<>());
        }

        for(int i = 0 ; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            map.get(u).add(v);
            map.get(v).add(u);
        }

        bfs(1);

        System.out.println(cnt);
    }

    public static void bfs(int node){
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visit[node] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            cnt++;
            for(int next : map.get(cur)){
                if(!visit[next]){
                    visit[next] = true;
                    q.offer(next);
                }
            }
        }

    }
}