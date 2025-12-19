class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int r = land.length;
        int c = land[0].length;
       
        int[][] dp = new int[r][c];
        for(int i = 1; i < r; i++){
            for(int j = 0 ; j < 4 ; j++){ // 0 1 2 3
                int max = 0;
                for(int k = 0 ; k < 4; k++){ // 0 1 2 3
                    if(j == k) continue;
                    max = Math.max(max, land[i-1][k]);
                }
                land[i][j] += max;
            }
        }
        
        for(int i = 0; i < 4; i++){
            answer = Math.max(answer, land[r-1][i]);
        }
            
        return answer;
    }
}