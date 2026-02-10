import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int left = 1;
        int right = 0;
        for(int n : stones){
            right = Math.max(right, n);
        }
        
        while(left <= right){ // 1 5
            int mid = (left + right) / 2; //25
            
            int cnt = 0;
            for(int i = 0; i< stones.length; i++){
                if(stones[i] - mid <= 0) cnt++;
                else cnt = 0;
                if(cnt == k) break;
            }
            
            if(cnt == k) 
                right = mid-1; 
            else
                left = mid+1;
        }
        return left;
    }
}