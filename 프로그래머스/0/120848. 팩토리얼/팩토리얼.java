class Solution {
    public int solution(int n) {
        int[] dp = new int[11];
        dp[1] = 1;
        for(int i = 2 ; i<=10; i++){
            dp[i] = i*dp[i-1];
        }
        for(int m : dp){
            System.out.println(m);
        }
        for(int i = 1 ; i <= 10 ;i++){
            if(n == dp[i]){
                return i;
                
            }
            else if(n > dp[i-1] && n < dp[i])
                return i-1;
        }
        int answer = 0;
        return answer;
    }
}