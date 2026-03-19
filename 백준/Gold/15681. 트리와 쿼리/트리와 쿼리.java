import java.io.*;
import java.util.*;


public class Main {
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visit;
    static int N;
    static int[] subtree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        visit = new boolean[N+1];
        subtree = new int[N+1];
        for(int i =0 ; i <= N; i++)
            list.add(new ArrayList<>());

        for(int i =0 ; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.get(u).add(v);
            list.get(v).add(u);
        }

        visit[R] = true;
        dfs(R);

        for(int i = 0; i < Q; i++){
            int n = Integer.parseInt(br.readLine());
            System.out.println(subtree[n]);
        }
    }
    public static void dfs(int node){
        subtree[node] = 1;
        for(int n : list.get(node)){
            if(!visit[n]){
                visit[n] = true;
                dfs(n);
                subtree[node] += subtree[n];
            }
        }
    }
}