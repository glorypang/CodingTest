import org.w3c.dom.Node;

import javax.lang.model.type.ArrayType;
import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static List<List<int[]>> graph;
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
        graph = new ArrayList<>();
        for(int i = 0; i <= N ;i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = 1;

            graph.get(s).add(new int[]{e, w});
        }
        dijkstra(X);

        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= N ; i++){
            if(dist[i] == K){
                list.add(i);
            }
        }
        Collections.sort(list);

        if(list.size() == 0){
            System.out.println(-1);
        }
        else {
            for (int n : list){
                System.out.println(n);
            }
        }
    }
    public static void dijkstra(int start) {
        Arrays.fill(dist, INF);
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

                int newDist = curDist + weight;
                if(newDist < dist[nextNode]){
                    dist[nextNode] = newDist;
                    pq.offer(new int[]{nextNode,newDist});
                }
            }
        }
    }
}
