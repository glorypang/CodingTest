class Solution {
    public String solution(String s) {
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ' ') idx = -1;
            
            if(Character.isDigit(c)) {
                sb.append(c);
                idx++;
                continue;
            }
            
            if(idx == 0) 
                sb.append(Character.toUpperCase(c));
            else
                sb.append(Character.toLowerCase(c));
            
            idx++;
        }
        return sb.toString();
    }
}