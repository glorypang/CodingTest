class Solution {
    public int solution(int num1) {
        int answer = 0;
        long num = Long.valueOf(num1);
        while(answer < 500){
            if(num == 1){
                return answer;    
            }
            if(num %2== 0)
                num /= 2;
            else{
                num = num*3 +1;
            }
            answer++;
        }
        return answer >= 500 ? -1 : answer;
    }
}