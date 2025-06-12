class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] sound = { "aya", "ye", "woo", "ma"};
        
        for(String str : babbling){
            
            boolean check = true;
            for(String s : sound){
                if(str.contains(s+s)){
                    check = false;
                    break;
                }
            }
            if(check){
                String s = str;
                s = s.replaceAll("(aya|ye|woo|ma)", "");
				
                if(s.length() == 0) answer++;
            }
        }
        return answer;
    }
}