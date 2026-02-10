import java.util.*;
class Solution {
    List<List<Integer>> list = new ArrayList<>();
    boolean[] visit;
    int cnt = 0;
    int total =0;
    public int solution(int n, int[][] edge) {
        for(int i = 0 ; i <= n ; i++)
            list.add(new ArrayList<>());
        visit = new boolean[n+1];
        
        for(int[] e : edge){
            int u = e[0]; int v = e[1];
            list.get(u).add(v);
            list.get(v).add(u);
        }
        visit[1] = true;
        bfs(1);
        return total;
    }
    
    void bfs(int node){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{node, 1});
        while(!q.isEmpty()){
            int size = q.size();
            total = 0;
            for(int a = 0 ; a < size; a++){
                int[] nums = q.poll();
                int num = nums[0];
                if(cnt == nums[1]){
                    total++;
                }
                for(int i = 0; i < list.get(num).size(); i++){
                    if(!visit[list.get(num).get(i)]){
                        visit[list.get(num).get(i)] = true;
                        q.offer(new int[]{list.get(num).get(i), cnt+1});
                    }
                }
            }
            cnt++;
        }
    }
}