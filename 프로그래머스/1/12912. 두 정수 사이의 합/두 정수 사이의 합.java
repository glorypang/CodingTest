class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int start;
        int end;
        
        if(a >b){
            end =a;
            start= b;
        }
        else{
            start = a;
            end = b;
        }
        for(int i = start ; i <= end; i++){
            answer += i;
        }
        return answer;
    }
}