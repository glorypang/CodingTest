class Solution {
    public int[] solution(long n) {
        int len = (int)Math.log10(n)+1;
        int[] answer = new int[len];
        
        long num = n;
        int idx = 0;
        while(num != 0){
            answer[idx++] = (int)(num %10);
            num /= 10;
        }        
        return answer;
    }
}