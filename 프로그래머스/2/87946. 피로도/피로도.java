class Solution {
    int[][] dungeon;
    int max = 0;
    boolean[] visit;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        dungeon = dungeons;
        visit = new boolean[dungeon.length];
        for(int i = 0 ; i < dungeon.length; i++){
            visit[i] = true;
            dfs(1,i,k);
            visit[i] = false;
        }
        return max;
    }
    void dfs(int cnt, int cur, int remain){
        if(remain-dungeon[cur][1] < 0 || remain < dungeon[cur][0]) return ;
        //System.out.println(cnt + ", " + cur + ", " + remain);
        remain -= dungeon[cur][1];
        for(int i = 0 ; i < dungeon.length; i++){
        max = Math.max(max, cnt);
            
            if(!visit[i]){
                visit[i] = true;
                dfs(cnt+1, i, remain); // dfs(1, 1, 60), dfs(1, 2, 60) -> dfs(2, 1, 50) -> dfs(3, 0, 10), dfs(3, 1, 10), dfs(3, , 10)
                
                visit[i] = false;
            }    
        }
        
    }
}