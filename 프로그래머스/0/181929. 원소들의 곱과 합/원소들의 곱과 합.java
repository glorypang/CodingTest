class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int temp = 1;
        for(int n : num_list){
            temp *= n;
            answer += n;
        }
        return temp < answer*answer ? 1 : 0;
    }
}