class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        for(int t = 0 ; t < s.length; t++){
            StringBuilder sb = new StringBuilder();
            int count = 0;
            for(int i = 0; i < s[t].length(); i++){
                sb.append(s[t].charAt(i));
                int len = sb.length();
                if(len >= 3 && 
                    sb.charAt(len-3) == '1' && 
                    sb.charAt(len-2) == '1' && 
                    sb.charAt(len-1) == '0'){
                    count++;
                    sb.setLength(len-3);
                }
            }
            int n = sb.lastIndexOf("0");
            sb.insert(n+1, "110".repeat(count));
            answer[t] = sb.toString();
            // System.out.println(sb.toString());
        }
        
        
        return answer;
        
    }
}