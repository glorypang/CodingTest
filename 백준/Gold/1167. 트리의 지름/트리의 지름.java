import java.io.*;
import java.util.*;

public class Main {
    static List<List<int[]>> list = new ArrayList<>();
    static final int INF = 1_000_000_000;
    static int[] dist;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for(int i =0 ; i <= N ; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());

            while(true){
                int e = Integer.parseInt(st.nextToken());
                if(e == -1) break;
                int w = Integer.parseInt(st.nextToken());

                list.get(s).add(new int[]{e, w});
            }
        }

        int max = Integer.MIN_VALUE;
//        for(int i = 1; i <= N; i++){ // root 순회
            // 가장 깊은 노드 찾고
            dijkstra(1);

            int depthNode = 0;
            int length = 0;
            for(int j = 1; j <= N; j++){
                if(dist[j] > length){
                    length = dist[j];
                    depthNode = j;
                }
            }
            // 해당 노드에서 다익스트라로 가장 먼 노드찾기
            dijkstra(depthNode);

            for(int j =  1; j <= N; j++){
                max = Math.max(dist[j], max);
            }
//        }
        System.out.println(max);
    }
    static void dijkstra(int start){
        dist = new int[N+1];
        for(int i = 0; i<= N; i++)
            Arrays.fill(dist, INF);

        PriorityQueue<int[]> pq= new PriorityQueue<>((o1, o2)-> o1[1] - o2[1]);
        pq.offer(new int[]{start, 0});
        dist[start] = 0;

        while (!pq.isEmpty()){
            int[] cur = pq.poll();
            int curNode= cur[0];
            int curDist = cur[1];

            if(curDist != dist[curNode]) continue;

            for(int[] next : list.get(curNode)){
                int nextNode = next[0];
                int weight = next[1];

                int newDist = weight + curDist;
                if(newDist < dist[nextNode]){
                    dist[nextNode] = newDist;
                    pq.offer(new int[]{nextNode, newDist});
                }
            }
        }

    }
}
