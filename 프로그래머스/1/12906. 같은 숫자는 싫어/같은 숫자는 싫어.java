import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stc = new Stack<Integer>();
        
        for(int i = 0 ; i< arr.length ; i++){
            if(stc.isEmpty()){
                stc.push(arr[i]);
            }
            else{
                if(stc.peek() == arr[i]){
                    continue;
                }
                else stc.push(arr[i]);
            }
        }
        
        int[] answer = new int[stc.size()];
        int idx = 0;
        for(int c : stc){
            answer[idx++] = c;
        }
        
                    
        return answer;
    }
}