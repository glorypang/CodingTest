import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> st = new Stack<>();
        
        for(char ch : s.toCharArray()){
            if(st.empty()){
                st.push(ch);
            }
            else {
                if(st.peek() == '(' && ch == ')') st.pop();
                else st.push(ch);
            }
        }
        
        if(st.size() == 0){
            return true;
        }

        return false;
    }
}