import java.util.*;

class Solution {
    List<List<Integer>> g;
    boolean[] visit;
    int[] dist;
    int N;
    int maxDepth = 0;
    public int solution(int n, int[][] edge) {
        N = n;
        g = new ArrayList<>();
        for(int i = 0 ; i<= N; i++){
            g.add(new ArrayList<>());
        }
        visit = new boolean[n+1];
        dist = new int[n+1];
        
        for(int[] e : edge){
            int u = e[0];
            int v = e[1];
            
            g.get(u).add(v);
            g.get(v).add(u);
        }
        bfs(1);
        int cnt = 0;
        for(int na : dist){
            if(maxDepth-1 == na)
                cnt++;
        }
        return cnt;
    }
    
    public void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visit[start] = true;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i< size; i++){
                int cur = q.poll();
                for(int next : g.get(cur)){
                    if(!visit[next]){
                        visit[next] = true;
                        q.offer(next);
                        dist[next] = dist[cur] +1;
                    }
                }
            }
            maxDepth++;
        }
    }
}