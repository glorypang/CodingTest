class Solution {
    public int solution(String s) {
        int answer = 0;
        char cha = s.charAt(0);
        int num = 0;
        for(int i = 0 ; i < s.length(); i++){
            if(cha == s.charAt(i))
                num++;            
                
            else{
                num--;
            }
            
            if(num == 0 && i < s.length()-1){
                answer++;
                cha = s.charAt(i+1);
            }
        }
        return answer+1;
    }
}