class Solution {
    public long solution(long n) {
        long answer = -1;
        if(Math.floor(Math.sqrt(n)) == Math.sqrt(n)){
            return (long)(Math.sqrt(n)+1) * (long)(Math.sqrt(n)+1);
        }
        return answer;
    }
}