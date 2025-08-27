class Solution {
    public int solution(int[] box, int n) {
        int answer = 1;
        for(int m : box){
            answer *= m/n;
        }
        return answer;
    }
}