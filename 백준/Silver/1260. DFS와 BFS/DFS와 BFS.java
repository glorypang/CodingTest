import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }
        for(int i = 1; i <= N; i++){
            Collections.sort(graph[i]);
        }
        dfs(V);
        sb.append("\n");
        Arrays.fill(visited, false);
        bfs(V);
        System.out.println(sb);

    }

    public static void dfs(int v){
        visited[v] = true;
        sb.append(v).append(" ");
        for(int w : graph[v]){
            if(!visited[w]){
                dfs(w);
            }
        }
    }

    public static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        visited[v] = true;
        sb.append(v).append(" ");
        q.add(v);

        while(!q.isEmpty()){
            int u = q.poll();
            for(int next : graph[u]){
                if(!visited[next]){
                    visited[next] = true;
                    sb.append(next).append(" ");

                    q.add(next);
                }
            }
        }
    }
}
