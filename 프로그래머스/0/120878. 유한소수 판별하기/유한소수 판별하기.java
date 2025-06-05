import java.math.*;

class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        int par = b;
        if(gcd(a,b) != 0){
            par = b/gcd(a,b);
        }
        while(true){
            if(par% 2 == 0){
                par /= 2;
            }
            else if(par % 5 == 0){
                par /= 5;
            }
            else if(par == 1){
                return 1;
            }
            else {
                return 2;
            }
        }
    }
    public int gcd(int n, int m){
        BigInteger n1 = BigInteger.valueOf(n);
        BigInteger n2 = BigInteger.valueOf(m);
        BigInteger n3 = n1.gcd(n2);
        
        return n3.intValue();
    }
}