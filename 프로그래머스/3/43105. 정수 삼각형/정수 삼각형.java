class Solution {
    public int solution(int[][] triangle) {
        int max = Integer.MIN_VALUE;
        int answer = 0;
        int n = triangle.length;
        int m = triangle[n-1].length;
        int[][] dp = new int[n+1][m+2];
        
        for(int i = 0; i < triangle.length ; i++){
            for(int j = 0 ; j < triangle[i].length; j++){
                dp[i+1][j+1] = triangle[i][j] + Math.max(dp[i][j], dp[i][j+1]);
                max = Math.max(max, dp[i+1][j+1]);
            }
        }
        
        // for(int[] l : dp){
        //     System.out.println();
        //     for(int k : l){
        //         System.out.print(k);
        //     }
        // }
        //     System.out.println(max);
        
        return max;
    }
}