class Solution {
    int N;
    int P;
    
    public int solution(int number, int limit, int power) {
        int answer = 0;
        N = limit;
        P = power;
        // for(int i = 1 ; i <= number; i++){
        //     if(yak(i) <= limit) answer += yak(i);
        //     else answer += power;
        // }
        for(int i = 1; i<= number; i++){
            answer += yak(i);
            //System.out.println(yak(i));
        }
        return answer;
    }
    
    public int yak(int n){
        int cnt = 2;
        if(n == 1) return 1;
        for(int i = 2; i <= n/2; i++){
            if(n%i == 0){
                cnt++;
            }
            if(cnt > N) return P;
        }
        return cnt;
    }
}