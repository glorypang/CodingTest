import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> g;
    static boolean[] visit;
    static int N;
    static int[] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visit = new boolean[N + 1];
        res = new int[N + 1];
        g = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            g.get(u).add(v);
            g.get(v).add(u);
        }
        dfs(1);

        for(int i = 2 ; i<= N ; i++){
            System.out.println(res[i]);
        }
    }

    public static void dfs(int n) {
        visit[n] = true;
        for (int next : g.get(n)) {
            if (!visit[next]) {
                visit[next] = true;
                res[next] = n;
                dfs(next);

            }
        }
    }
}