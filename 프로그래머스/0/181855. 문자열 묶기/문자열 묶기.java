class Solution {
    public int solution(String[] strArr) {
        int answer = 0;
        int[] len = new int[31];
        for(String s : strArr){
            len[s.length()]++;
        }
        
        for(int i = 1 ; i<= 30 ;i++){
            answer = Math.max(answer, len[i]);
        }
        return answer;
    }
}