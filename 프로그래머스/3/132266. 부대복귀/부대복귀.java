import java.util.*;
class Solution {
    List<List<int[]>> list = new ArrayList<>();
    int INF = Integer.MAX_VALUE;
    int[] dist;
    boolean[] visit;
    int count;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        dist =  new int[n+1];
        Arrays.fill(dist, INF);
        
        for(int i = 0 ; i <= n ; i++)
            list.add(new ArrayList<>());
        
        for(int[] r : roads){
            int s = r[0]; int e = r[1]; int w = 1;
            list.get(s).add(new int[] {e, w});
            list.get(e).add(new int[]{s, 1});

        }
    
        dijkstra(destination);
        
        int[] answer = new int[sources.length];
        
        
        for(int i = 0 ; i < sources.length; i++){
            answer[i] =  dist[sources[i]] == INF ? -1 : dist[sources[i]];
        }
        return answer;
    }
    
    void dijkstra(int start){
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n1[1] - n2[1]);
        pq.offer(new int[]{start, 0});
        dist[start] = 0;
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curDist = cur[1];
            
            if(curDist != dist[curNode])
                continue;
            
            for(int[] next : list.get(curNode)){
                int nextNode = next[0];
                int weight = next[1];
                
                int newDist = curDist + weight;
                if(dist[nextNode] > newDist){
                    dist[nextNode] = newDist;
                    pq.offer(new int[]{nextNode, newDist});
                }
            }
        }
    }
}