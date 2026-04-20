import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Deque<Character> st = new ArrayDeque<>();
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if(st.isEmpty()){
                st.offerLast(c);
            }
            else{
                if(st.peekLast() == '(' && c == ')')
                    st.removeLast();
                else{
                    st.offerLast(c);
                }
            }
        }
        
        if(st.isEmpty())
            return true;


        return false;
    }
}