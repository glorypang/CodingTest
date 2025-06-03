import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        Arrays.fill(answer, -1);
        Set<Integer> set = new LinkedHashSet<>();
        for(int n : arr){
            set.add(n);
        }
       
        int i = 0 ;
        for(int n: set){
            if(i >= k)
                break;
            answer[i++] = n; 
            
        }
        return answer;
    }
}