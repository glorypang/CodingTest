import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> list;
    static boolean[] visit;
    static int[] parent;
    static int[] depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            list = new ArrayList<>();
            visit = new boolean[N + 1];
            parent = new int[N + 1];
            depth = new int[N + 1];
            for (int j = 0; j <= N; j++)
                list.add(new ArrayList<>());


            int root =0;
            for (int j = 1; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                if(root == 0) root = u;
                list.get(u).add(v);
                list.get(v).add(u);
            }
            dfs(root, 0, 0);

            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int lca = LCA(s, e);
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

    static int LCA(int a, int b){
        while(depth[a] > depth[b])
            a = parent[a];

        while(depth[a] < depth[b])
            b = parent[b];

        while(a != b){
            a = parent[a];
            b = parent[b];
        }
        return a;
    }
}
