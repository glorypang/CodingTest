class Solution {
    public int solution(int n) {
        int answer = 1;
        int start = 1;
        int end = 1;
        int cnt = 0;
        while(true){
            if(end > n) break;

            if(answer == n) {
                cnt++; // 1 2 3
                answer -= start;
                start++;
            }
            if(answer <= n) {
                end++; // 3 4 5 6 7 8
                answer += end; // 3 6 10 15 21 22 21
            }
            else if(answer > n){ 
                answer -= start; // 20 18 15 18 13 15
                start++; // 2 3 4 5 6 7
            }
        }
        
        return cnt;
    }
}