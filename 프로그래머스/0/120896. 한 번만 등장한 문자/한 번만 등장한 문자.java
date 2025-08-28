class Solution {
    public String solution(String s) {
        int[] alpha = new int[26];
        String answer = "";
        for(char c : s.toCharArray()){
            int n = c - 'a';
            alpha[n]++;
        }
        
        for(int i = 0 ; i < 26; i++){
            if(alpha[i] == 1)
                answer += (char)(i + 97) + "";
        }
        return answer;
    }
}