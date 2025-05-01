import java.util.*;
class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = {};
        int[] lists = new int[emergency.length];
        Arrays.fill(lists, 1);
        
        for(int n : emergency){
            for(int i = 0 ; i < emergency.length; i++){
                if(emergency[i] < n)
                    lists[i]++;
            }
        }
        
        
        return lists;
    }
}