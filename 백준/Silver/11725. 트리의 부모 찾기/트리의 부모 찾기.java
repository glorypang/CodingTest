import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> tree;
    static Map<Integer, Integer> parent;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }
        parent = new HashMap<>();
        visited = new boolean[N+1];

        for(int i = 0 ; i < N-1 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        dfs(1);
        for(int i = 2 ; i <= N ; i++) {
            System.out.println(parent.get(i));
        }
    }
    public static void dfs(int start){
        visited[start] = true;

        for(int next: tree.get(start)) {
            if(!visited[next]) {
                parent.put(next, start);
                dfs(next);
            }
        }
    }
}