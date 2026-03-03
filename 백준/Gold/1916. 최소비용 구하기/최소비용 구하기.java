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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(s).add(new int[]{e, w});
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dijkstra(start);
//        for(int i = 1; i <= N; i++){
//            System.out.println(dist[i]);
//        }
        System.out.println(dist[end]);
    }
    public static void dijkstra(int start){
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n1[1] - n2[1]);
        pq.offer(new int[] {start, 0});
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
                int newDist = curDist + weight;
                if(dist[nextNode] > newDist){
                    dist[nextNode] = newDist;
                    pq.offer(new int[] {nextNode, newDist});
                }
            }
        }


    }
}
