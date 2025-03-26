class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        for(String s : s1){
            
            for(int i = 0 ; i < s2.length ; i++){
                if(s.equals(s2[i])) answer++;
            }
        }
        return answer;
    }
}