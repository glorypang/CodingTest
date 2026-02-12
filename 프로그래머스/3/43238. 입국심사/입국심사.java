import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        
        long left = 1;
        long right = Long.MAX_VALUE;
        while(left <= right){
            long mid = left + (right-left) / 2;
            long cnt = 0;
            
            for(int t : times){
                cnt += mid/t;
                if(cnt > n) break;
            }
            
            if(cnt >= n) 
                right = mid -1;
            else if(cnt < n) 
                left = mid + 1;
        }
        return left;
    }
}