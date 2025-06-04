class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        int len = spell.length;
        for(String str : dic){
            int cnt = 0;
            for(int i = 0 ; i < len; i++){
                if(str.contains(spell[i])){
                    cnt++;
                }          
            }
            if(cnt == len){
                return 1;
            }
        }
        
        return answer;
    }
}