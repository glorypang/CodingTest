class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i <= n; i++){
            if (isPrime(i)){
                answer++;
            }
        }
        return answer;
    }

    public static boolean isPrime(int n){
        if(n < 2){
            return false;
        }
        for(int i = 2; i <= Math.sqrt(n); i++){
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}