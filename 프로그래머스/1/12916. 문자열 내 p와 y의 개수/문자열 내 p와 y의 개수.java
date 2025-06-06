class Solution {
    boolean solution(String s) {
        boolean answer = false;
        s= s.toLowerCase();
        int cnt = 0;
        for(char c: s.toCharArray()){
            if(c=='p'){
                cnt++;
            }
            else if(c=='y'){
                cnt--;
            }
        }
        if(cnt == 0){
            return true;
        }
        return answer;
    }
}