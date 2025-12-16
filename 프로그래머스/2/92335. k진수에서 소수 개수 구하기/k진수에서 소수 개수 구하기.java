import java.util.*;
class Solution {
    boolean[] prime;
    
    public int solution(int n, int k) {
        int answer = 0;
        String str = to(n, k);
        str = str.replaceAll("0+", "0");
        String[] s = str.split("0");
        for(String st : s){
            System.out.println(st+ ", " + isPrime(Long.parseLong(st)));
            if(isPrime(Long.parseLong(st))){
                answer++;
            }
            // System.out.println(st);
            
        }

        return answer;
    }
    
    String to(int n, int k){
        StringBuilder sb = new StringBuilder();
        while(n!=0){
            sb.append(n%k);
            n /= k;
        }
        return sb.reverse().toString();
    }
//     boolean isPrime(long x){
//         prime = new boolean[x+1];
//         Arrays.fill(prime, true);
//         prime[0] = false;
//         prime[1] = false;
        
//         for(long i = 2; i <= Math.sqrt(x); i++){
//             if(prime[i]){
//                 for(long j = i*i ; j <= x; j +=i){
//                     prime[j] = false;
//                 }                
//             }
//         }

//         return prime[x];
        
//     }
    boolean isPrime(long x) {
        if (x < 2) return false;

        for (long i = 2; i * i <= x; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }
}