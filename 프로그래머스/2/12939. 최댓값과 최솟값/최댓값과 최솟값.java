class Solution {
    public String solution(String s) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        String[] c = s.split(" ");
        for(String ch : c){
            int n = Integer.parseInt(ch);
            max = Math.max(n, max);
            min = Math.min(n, min);
        }
        
       
        StringBuilder sb = new StringBuilder();
        sb.append(min);
        sb.append(" ");
        sb.append(max);
        
        return sb.toString();
    }
}