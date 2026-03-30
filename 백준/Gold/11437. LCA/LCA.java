import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> list =new ArrayList<>();
    static int[] parent;
    static boolean[] visit;
    static int[] depth;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        visit = new boolean[N+1];
        depth = new int[N+1];
        for(int i = 0; i <= N; i++)
            list.add(new ArrayList<>());

        StringTokenizer st;
        for(int i = 1; i < N; i++){
            st =new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.get(u).add(v);
            list.get(v).add(u);
        }

        dfs(1, 0, 0);

        int M = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < M; i++){
            st =new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            int lca = LCA(u, v);
            System.out.println(lca);
        }
    }

    static void dfs(int node, int par, int de){
        visit[node] = true;
        parent[node] = par;
        depth[node] = de;

        for(int next : list.get(node)){
            if(!visit[next]){
                dfs(next, node, de+1);
            }
        }
    }

    static int LCA(int node1, int node2){
        while(depth[node1] > depth[node2])
            node1 = parent[node1];
        while(depth[node1] < depth[node2])
            node2 = parent[node2];

        while(node1 != node2){
            node1 = parent[node1];
            node2 = parent[node2];
        }
        return node1;
    }
}