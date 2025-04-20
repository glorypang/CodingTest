class Solution {
    public String solution(String cipher, int code) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        int idx = 1;
        for(char c : cipher.toCharArray()){
            if(idx%code == 0){
                sb.append(c);
            }
            idx++;
        }
        return sb.toString();
    }
}