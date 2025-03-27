class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[2];
        for(int n : num_list){
            if(n % 2 == 1) answer[1]++;
            else answer[0]++;
        }
        return answer;
    }
}