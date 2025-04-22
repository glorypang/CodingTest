class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        if(num_list.length >= 11) {
            for(int c : num_list){
                answer += c;
            }
        }
        else{
            answer = 1;
             for(int c : num_list){
                answer *= c;
            }
        }        
        return answer;
    }
}