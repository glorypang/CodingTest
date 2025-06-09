import java.math.*;
class Solution {
    public int[] solution(int n, int m) {
        return new int[]{gcd(n,m), (n*m)/gcd(n,m)};
    }
    public int gcd(int n, int m){
        BigInteger a = BigInteger.valueOf(n);
        BigInteger b = BigInteger.valueOf(m);
        BigInteger c = a.gcd(b);
        
        return c.intValue();
    }
}