class Solution {
    public int solution(String number) {
        int answer = 0;
        for(char c : number.toCharArray()){
            int n = c -'0';
            answer += n;
        }
        return answer%9;
    }
}