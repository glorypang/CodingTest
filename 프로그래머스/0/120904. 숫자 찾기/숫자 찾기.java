class Solution {
    public int solution(int num, int k) {
        int answer = -1;
        String str = Integer.toString(num);
        int cnt = 0;
        for(char c : str.toCharArray()){
            cnt++;
            if(c-'0' == k){
                return cnt;
            }
        }
        return answer;
    }
}