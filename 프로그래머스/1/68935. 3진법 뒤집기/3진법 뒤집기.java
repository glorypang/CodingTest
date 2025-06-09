import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        List<Integer> list = new ArrayList<>();
        
        while(n != 0 ){
            list.add(n%3);
            n /= 3;
        }
        int len = list.size();
        int sum = 0;

        for(int i = len-1 ; i >= 0; i--){
            //System.out.println((int)Math.pow(list.get(len-i-1), 3));
            sum +=list.get(len-i-1) * (int)Math.pow(3, i);
        }
        
        return sum;
    }
}