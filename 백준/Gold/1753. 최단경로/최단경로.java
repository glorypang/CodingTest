import org.w3c.dom.Node;

import javax.lang.model.type.ArrayType;
import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static List<List<int[]>> graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        dist = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i = 0 ; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(s).add(new int[]{e,w});
        }

        dijkstra(K);

        for(int i = 1 ; i <= V ; i++) {
            System.out.println(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]);
        }
    }
    public static void dijkstra(int start){
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n1[1] - n2[1]);
        pq.offer(new int[]{start,0});
        dist[start] = 0;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curDist = cur[1];

            if(curDist > dist[curNode]){
                continue;
            }

            for(int[] next : graph.get(curNode)){
                int nextNode = next[0];
                int weight = next[1];
                int nextDist = curDist + weight;
                if(dist[nextNode] > nextDist){
                    dist[nextNode] = nextDist;
                    pq.offer(new int[]{nextNode,nextDist});
                }
            }
        }
    }
}
