class Solution {
    public String solution(String s) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        String[] strs = s.split(" ");
        for(String str : strs){
            int n = Integer.parseInt(str);
            max = Math.max(n, max);
            min = Math.min(n, min);
        }
        String answer = min + " " + max;
        return answer;
    }
}