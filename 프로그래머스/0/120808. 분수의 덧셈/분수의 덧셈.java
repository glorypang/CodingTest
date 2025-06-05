import java.util.*;
import java.math.*;
class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = {};
        int par = denom1*denom2;
        int chi = numer1*denom2 + numer2*denom1;
        int n = gcd(par,chi);
        
        return new int[]{chi/n, par/n};
    }
    public int gcd(int n, int m){
        BigInteger a = BigInteger.valueOf(n);
        BigInteger b = BigInteger.valueOf(m);
        BigInteger c = a.gcd(b);
        
        return c.intValue();
        
    }
}