import java.util.*;
class Solution {
    public int solution(int n) {
        boolean[] isPrime = getPrime(n);
        int answer = 0;

        for(int i = 2 ; i<=n ;i++){
            if(isPrime[i]){
                answer++;
            }
        }
        
        return answer;
    }
    
   	public boolean[] getPrime(int n){
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        
        isPrime[0] = false;
        isPrime[1] = false;
        
        for(int i = 2; i <= Math.sqrt(n); i++){
          if(isPrime[i]){
              for(int j = i*i; j <=n ;j +=i){
                  isPrime[j] = false;
              }
          }  
        }
        return isPrime;
    }
}