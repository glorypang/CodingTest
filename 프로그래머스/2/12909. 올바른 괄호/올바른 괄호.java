import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> st = new Stack<>();
        for(Character c : s.toCharArray()){
            if(st.isEmpty()){
                st.push(c);
            }
            else{
                if(st.peek() == '(' && c == ')'){
                    st.pop();
                }
                else{
                    st.push(c);
                }
            }
        }
        if(st.isEmpty()){
            return true;
        }
        else return false;
        
    }
}