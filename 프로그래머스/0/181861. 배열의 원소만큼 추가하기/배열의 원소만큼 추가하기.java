import java.util.*;
class Solution {
    public int[] solution(int[] ar) {
        int[] answer = {};
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int n : ar){
            for(int i = 0 ; i< n ; i++){
                arr.add(n);
            }
        }
        int len = arr.size();
        answer = new int[len];
        for(int i = 0 ; i< len ; i++){
            answer[i] = arr.get(i);
        }
        return answer;
    }
}