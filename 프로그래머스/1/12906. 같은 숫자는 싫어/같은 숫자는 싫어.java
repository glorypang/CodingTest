import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < arr.length; i++){
            if(st.isEmpty()){
                st.push(arr[i]);
            }
            else{
                if(st.peek() == arr[i]){
                    continue;
                }
                else{
                    st.push(arr[i]);
                }
            }
        }
        int[] answer = new int[st.size()];
        int idx = 0;
        for(int i : st){
            answer[idx++] = i;
        }
        
        return answer;
    }
}