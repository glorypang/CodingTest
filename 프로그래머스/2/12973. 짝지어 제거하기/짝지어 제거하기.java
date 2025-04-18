import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;

        Stack <Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(stack.isEmpty()) stack.push(c);
            else{
                if(stack.peek() == c) stack.pop();
                else stack.push(c);
            }
        }
        if(stack.isEmpty()) return 1;
        
        return 0;
    }
}