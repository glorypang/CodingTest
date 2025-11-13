import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> st = new Stack<>();
        char[] list = s.toCharArray();
        
        for(char c : list){
            if(st.isEmpty()){
                st.push(c);
            }
            else{
                if(st.peek() == '(' && c == ')') st.pop();
                else st.push(c);
            }
        }
        
        if(st.isEmpty()) return answer;
        else return false;
        
    }
}