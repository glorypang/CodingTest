import java.util.*;
class Solution {
    int[][] dungeon;
    boolean[] visit;
    int n;
    int count;
    int answer = 0;
    public int solution(int k, int[][] dungeons) {
        dungeon = dungeons;
        n = dungeons.length;
        
        for(int i = 0 ; i< n ; i++){
            visit = new boolean[n+1];
            count = 1;
            if(dungeons[i][0] <= k)
                dfs(i, 0, k);
            answer = Math.max(answer, count);
            System.out.println();
        }
        
        return answer;
    }
    
    void dfs(int pos, int depth, int health){
        count = Math.max(count, depth);
        //System.out.println(pos +" " + depth +" " +health + " " + count);
        
        // if(health < dungeon[pos][0])
            // return;
        
        for(int i =0 ; i < n; i++){
            if(!visit[i] && health >= dungeon[i][0]){
                health -= dungeon[i][1];
                visit[i] = true;
                
                dfs(i, depth+1, health);
                health += dungeon[i][1];
                visit[i] = false;
            }
        }
    }
}