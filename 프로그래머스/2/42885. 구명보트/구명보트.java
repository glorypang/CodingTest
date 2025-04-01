import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int start = 0 ;
        int end = people.length -1;
        Arrays.sort(people);
        int cnt =0;
        
        while(start <= end){
            if(people[start] + people[end] <= limit)
                start++;                
            cnt++;
            end--;
        }
        
        return cnt;
    }
}