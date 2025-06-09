class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        int idx = 0;
        for(char c : s.toCharArray()){
            if(Character.isLetter(c)){
                if(idx%2 == 0){
                    c= Character.toUpperCase(c);
                }
                else{
                    c= Character.toLowerCase(c);
                }
                idx++;
            }
            else{
                idx = 0;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}