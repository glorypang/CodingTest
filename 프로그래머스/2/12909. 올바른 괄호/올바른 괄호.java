import java.util.*;

class Solution {
    boolean solution(String str) {
        Stack<Character> s = new Stack<>();
        for(char c: str.toCharArray()){
            if(s.isEmpty()) s.push(c);
            else{
                if(c == ')'){
                    if(s.peek() == '(') s.pop(); 
                }
                else s.push(c);
            }
        }
        if(s.isEmpty()) return true;
        else return false;

    }
}