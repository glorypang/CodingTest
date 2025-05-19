import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main {
    static List<List<int[]>> graph;
    static final int INF = Integer.MAX_VALUE;
    static int[] dist;    // 거리 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
//        int K = Integer.parseInt(br.readLine());


        graph = new ArrayList<>();
        for(int i = 0; i <= V; i++){
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(s).add(new int[]{e, w});
        }

        for(int i = 1 ; i <= V ; i++){
            dist = new int[V + 1];
            Arrays.fill(dist, INF);

            dijkstra(i);
            for(int j = 1; j <= V; j++){
                System.out.print(dist[j] == INF ? 0 +" " : dist[j]+" ");
            }
            System.out.println();
        }
    }
    public static void dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        dist[start] = 0;
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curDist = cur[1];

            if(curDist != dist[curNode]) continue;

            for(int[] next : graph.get(curNode)) {
                int nextNode = next[0];
                int weight = next[1];

                int newDist = curDist + weight;
                if(dist[nextNode] > newDist) {
                    dist[nextNode] = newDist;
                    pq.offer(new int[]{nextNode, newDist});
                }
            }
        }
    }
}
