import java.util.*;
class Solution {
    List<List<Integer>> list = new ArrayList<>();
    boolean[] visit;
    int cnt;
    int N;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        N = n;
        
        for(int i = 0 ; i <= n ; i++)
            list.add(new ArrayList());
        for(int[] wire : wires){
            int u = wire[0];
            int v = wire[1];
            list.get(u).add(v);
            list.get(v).add(u);
        }
         
        for(int[] wire : wires){
            int u = wire[0];
            int v = wire[1];
            list.get(u).remove((Integer)v);
            list.get(v).remove((Integer)u);
            cnt = 0;
            bfs(1);
            // System.out.println();
            System.out.println(u +", " + v+", " +cnt);
            // System.out.println();
            
            
            answer  = Math.min(answer, Math.abs(n-cnt-cnt));
            
            list.get(u).add(v);
            list.get(v).add(u);
            
        }
        
        return answer;
    }
    
    void bfs(int node){
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visit = new boolean[N+1];
        
        while(!q.isEmpty()){
            int n = q.poll();
            visit[n] = true;;
            cnt++;
            // System.out.print(n + " ");
            for(int num : list.get(n)){
                if(!visit[num]){
                    q.offer(num);
                }
            }
        }
    }
}