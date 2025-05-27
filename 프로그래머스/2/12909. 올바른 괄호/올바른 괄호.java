import java.util.*;
class Solution {
    boolean solution(String st) {
        boolean answer = true;

        Stack<Character> s = new Stack<>();
        for(char c : st.toCharArray()){
            if(s.isEmpty()){
                s.push(c);
            }else{
                if(s.peek() == ')') return false;
                
                if(c == '(') 
                    s.push(c);
                else{
                    if(s.size() == 0) return false;
                    s.pop();
                }
            }
        }
        if(s.size() != 0) return false;

        return answer;
    }
}