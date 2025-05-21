import org.w3c.dom.Node;

import javax.lang.model.type.ArrayType;
import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static List<List<Integer>> graph;
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;

    static boolean[] visited = new boolean[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        dist = new int[N+1];
        Arrays.fill(dist, -1);

        graph = new ArrayList<>();
        for(int i = 0; i <= N ;i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
        }
        bfs(X);
        boolean found = false;
        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) {
                System.out.println(i);
                found = true;
            }
        }

        if (!found) System.out.println(-1);
    }
    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist[start] = 0;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int next: graph.get(cur)){
                if(dist[next] == -1){
                    dist[next] = dist[cur] +1;
                    q.add(next);
                }
            }
        }
    }
}
