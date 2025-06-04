import java.math.*;
class Solution {
    public int solution(int balls, int share) {
        BigInteger a = fact(balls);
        BigInteger b = fact(balls - share).multiply(fact(share));
        BigInteger c = a.divide(b);

        return Integer.parseInt(c.toString());
    }
    public BigInteger fact(int n){
        BigInteger sum = new BigInteger("1");
        for(int i = 2 ; i <= n ; i++){
            sum = sum.multiply(BigInteger.valueOf(i));
        }
        return sum;
    }
}