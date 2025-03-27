class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        
        for(char c : s.toCharArray()){
            if(c == ' '){
                i = -1;
            }
            if(i%2 == 0 ) sb.append(Character.toUpperCase(c));
            else sb.append(Character.toLowerCase(c));
            
            i++;
        }
        return sb.toString();
    }
}