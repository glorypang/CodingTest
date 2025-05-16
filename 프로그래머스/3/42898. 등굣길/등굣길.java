import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];
        int[][] dp = new int[n+1][m+1];
        
        for(int[] p : puddles){
            map[p[1]-1][p[0]-1] = 1;
        }
        dp[1][1] = 1; // 시작 위치
        for(int i =0 ; i <n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(map[i][j] != 1){
                    dp[i+1][j+1] += (dp[i][j+1] + dp[i+1][j])%1000000007;
                }
            }
        }
        return dp[n][m];
    }
}