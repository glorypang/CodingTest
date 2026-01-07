import java.math.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcd = findGcd(arrayA);
        System.out.println(gcd);
        int gcd1 = findGcd(arrayB);
        System.out.println(gcd1);
        
        boolean check = false;
        for(int n : arrayB){
            if(n%gcd == 0 || gcd == 1) {
                check = true;
                break;
            }
        }

        boolean check1 = false;
        for(int n : arrayA){
            if(n%gcd1 == 0 || gcd1 == 1) {
                check1 = true;
                break;
            } 
        }
        
        if(check && check1) return 0;
        else if(!check && !check1)
            return Math.max(gcd, gcd1);
        else if(check) return gcd1;
        else if(check1) return gcd;
        else if(!check) return gcd;
        else if(!check1) return gcd1;
        return 0;
    }
    
    int findGcd(int[] arr){
        int len = arr.length;
        if(len == 1) return arr[0];
        
        BigInteger a = BigInteger.valueOf(arr[0]);
        BigInteger b = BigInteger.valueOf(arr[1]);
        BigInteger r = a.gcd(b);
        
        for(int i =2 ; i < arr.length; i++){
            BigInteger tmp = BigInteger.valueOf(arr[i]);
            r = r.gcd(tmp);
                        
        }
        return r.intValue();
    }
}