import java.io.*;
import java.util.*;

public class Main {
    static List<List<int[]>> list= new ArrayList<>();
    static int[] parent;
    static boolean[] visit;
    static int[] depth;
    static int[] level;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i<= N; i++)
            list.add(new ArrayList<>());

        for(int i = 1; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.get(u).add(new int[]{v, w});
            list.get(v).add(new int[]{u, w});
        }
        visit = new boolean[N+1];
        parent = new int[N+1];
        depth = new int[N+1];
        level = new int[N+1];
        dfs(1, 0 ,0, 0 );

        for(int i = 0 ; i< M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            int lca =LCA(u, v);
            System.out.println(depth[u] + depth[v] - (2 *depth[lca]));
        }
    }

    static void dfs(int node, int par, int de, int le){
        visit[node] = true;
        parent[node] = par;
        depth[node] = de;
        level[node] = le;

        for(int[] next : list.get(node)){
            if(!visit[next[0]]){
                dfs(next[0], node, de+next[1], le+1);
            }
        }
    }

    static int LCA(int a, int b){
        while(level[a] > level[b])
            a = parent[a];

        while(level[a] < level[b])
            b = parent[b];

        while(a != b){
            a= parent[a];
            b= parent[b];
        }
        return a;
    }
}