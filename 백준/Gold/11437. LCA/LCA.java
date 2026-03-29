import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> list = new ArrayList<>();
    static int[] parent;
    static int[] depth;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        for(int i = 0 ; i <= N ; i++)
            list.add(new ArrayList<>());

        for(int i = 1; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.get(u).add(v);
            list.get(v).add(u);
        }
        
        parent = new int[N + 1];
        depth = new int[N + 1];
        visited = new boolean[N + 1];
        
        dfs(1, 0, 0);

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int lca = LCA(u, v);
            sb.append(lca).append('\n');
        }
        System.out.print(sb);
    }

    static void dfs(int node, int par, int d){
        visited[node] = true;
        parent[node] = par;
        depth[node] = d;

        for(int next: list.get(node)){
            if(!visited[next]){
                dfs(next, node, d + 1);
            }
        }
    }
    
    static int LCA(int a, int b){
        // 깊이 맞추기
        while(depth[a] > depth[b]){
            a = parent[a];
        }
        while(depth[b] > depth[a]){
            b = parent[b];
        }
        
        // 같이 올라가기
        while(a != b){
            a = parent[a];
            b = parent[b];
        }
        
        return a;
    }
}