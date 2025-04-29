class Solution {
    public int solution(int n) {
        int answer = 1;
        int num = n;
        while(num%6 != 0){
            num += n;
            answer++;            
        }
        return num/6;
    }
}