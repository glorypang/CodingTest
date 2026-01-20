class Solution
{
    public int solution(int [][]board)
    {
        int answer =0;
        int r= board.length; int c = board[0].length;
        
        int[][] dp = new int[r+1][c+1];
        for(int i = 1 ; i <= r; i++){
            for(int j = 1 ; j  <=c ; j++){
                if(board[i-1][j-1] == 0) dp[i][j] =0;
                else{
                    dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]))+1;
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }
        
        // for(int i = 0 ; i < r; i++){
        //     for(int j  = 0 ; j < c ; j++){
        //         System.out.print(dp[i][j] +" ");
        //     }
        //     System.out.println();
        // }

        return answer*answer;
    }
}