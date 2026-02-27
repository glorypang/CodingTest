class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        boolean[][] wins = new boolean[n+1][n+1];
        for(int[] res : results){
            wins[res[0]][res[1]] = true;
        }
        
        for(int i = 1; i <= n ; i++){
            for(int j = 1; j <= n ; j++){
                for(int k = 1; k <= n ; k++){
                    if(wins[j][i] && wins[i][k]) wins[j][k] = true;
                }
            }
        }
        
        for(int i = 1; i <= n; i++){
            int count  = 0;
            for(int j = 1; j<= n ; j++){
                if(i == j) continue;
                if(wins[i][j] || wins[j][i]) count++;
            }
            if(count == n-1) answer++;
        }
        return answer;
    }
}