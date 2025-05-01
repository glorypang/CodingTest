class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        int idx = -1;
        while(myString.indexOf(pat, idx+1) >=0){
            idx = myString.indexOf(pat, idx+1);
            answer++;
        }
        return answer;
    }
}