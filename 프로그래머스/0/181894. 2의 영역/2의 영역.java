import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        Stack<Integer> st = new Stack<>();
        boolean check = false;
        for(int n : arr){
            if(n == 2){
                check = true;
            }
            if(check){
                st.push(n);
            }
        }
        if(st.size() == 0)
            return new int[]{-1};
        else{
            while(st.peek() != 2){
                st.pop();
            }
        }
        int len = st.size();
        answer = new int[len];
        int i = 0;
        for(int n : st){
            answer[i++] = n;
        }
        return answer;
    }
}