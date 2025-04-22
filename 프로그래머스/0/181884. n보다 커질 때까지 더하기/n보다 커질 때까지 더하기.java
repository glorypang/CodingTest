class Solution {
    public int solution(int[] numbers, int n) {
        int answer = 0;
        for(int a : numbers){
            if(answer <= n){
                answer += a;
            }
            else{
                break;
            }
        }
        return answer;
    }
}