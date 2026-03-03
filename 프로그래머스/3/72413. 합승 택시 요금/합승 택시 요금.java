import java.util.*;
class Solution {
    int INF = 1_000_000_000;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] map = new int[n+1][n+1];
        for(int i = 0; i <= n ; i++)
            Arrays.fill(map[i], INF);
        
        for(int[] f : fares){
            int u = f[0];
            int v = f[1];
            int w = f[2];
            map[u][v] = w;
            map[v][u] = w;
        }
        
        for(int k = 1; k <=n ; k++){
            for(int i = 1; i <= n; i++){
                for(int j =1; j <=n ; j++){
                    // if(map[i][k] + map[k][j] <= map[i][j]) 
                        map[i][j] = Math.min(map[i][k] + map[k][j], map[i][j]);
                }
            }
        }
        // for(int i = 1; i <= n; i++){
        //     for(int j =1; j <=n ; j++){
        //         System.out.print(map[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        int answer = map[s][a] + map[s][b];
        for(int i= 1; i <= n ; i++){
            if(map[s][i] == INF|| map[i][a] == INF || map[i][b] == INF ) continue;
            int std = map[s][i];
            if(s ==i) std = 0;
            if(i == a){
                std += map[i][b];
            }
            else if(i == b){
                std += map[i][a];
            }
            else
                std += (map[i][a] + map[i][b]);
            
            answer = Math.min(std, answer);
        }
        return answer;
    }
}