class Solution {
    public int solution(int[] array) {
        int answer = 0;

        for(int n : array){
            String s = n + "";
            for(char c : s.toCharArray()){
                if(c == '7') answer++;
            }
        }
        return answer;
    }
}