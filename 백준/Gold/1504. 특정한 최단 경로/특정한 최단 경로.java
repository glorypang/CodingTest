import java.io.*;
import java.util.*;

public class Main{
    public static int INF = 1_000_000_000;
    public static List<List<int[]>> list = new ArrayList<>();
    public static int N;
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i <= N; i++)
            list.add(new ArrayList<>());

        for(int i = 0 ; i< E; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.get(s).add(new int[]{e, w});
            list.get(e).add(new int[]{s, w});
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        long[] d1 = dijkstra(1);
        long[] dv1 = dijkstra(v1);
        long[] dv2 = dijkstra(v2);

        long path1 = safeSum(d1[v1], dv1[v2], dv2[N]); // 1->v1->v2->N
        long path2 = safeSum(d1[v2], dv2[v1], dv1[N]); // 1->v2->v1->N

        long ans = Math.min(path1, path2);
        System.out.println(ans >= INF ? -1 : ans);



    }
    public static long safeSum(long a, long b, long c) {
        if (a >= INF || b >= INF || c >= INF) return INF;
        return a + b + c;
    }

    public static long[] dijkstra(int start) {
        long[] dist = new long[N + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<int[]> pq=  new PriorityQueue<>((o1, o2)-> o1[1]-o2[1]);
        pq.offer(new int[]{start, 0});
        dist[start] = 0;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curDist = cur[1];

            if(dist[curNode] != curDist) continue;

            for(int[] next : list.get(curNode)){
                int nextNode = next[0];
                int weight = next[1];

                int newDist = curDist+weight;
                if(newDist < dist[nextNode]){
                    dist[nextNode] = newDist;
                    pq.offer(new int[]{nextNode, newDist});
                }
            }
        }
        return dist;

    }
}