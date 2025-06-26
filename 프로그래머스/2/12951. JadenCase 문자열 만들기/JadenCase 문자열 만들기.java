class Solution {
    public String solution(String s) {
        String answer = "";
        s =s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        
        int idx = 0;
        for(char c : s.toCharArray()){
            if(idx == 0 && Character.isLetter(c)){
                sb.append(Character.toUpperCase(c));
            }
            else if(c == ' '){
                idx = 0;
                sb.append(c);

            }
            else{
                sb.append(c);
            }
            
            if(c != ' '){
                idx++;
            }
        }
        
        
        return sb.toString();
    }
}