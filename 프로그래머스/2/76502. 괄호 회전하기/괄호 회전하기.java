import java.util.*;

class Solution {
    public int solution(String s) {
        int len = s.length();
        String temp =s;
        int answer = 0;
        
        while(len-- > 0){
            Stack<Character> st = new Stack<>();
            for(char c: temp.toCharArray()){
                if(st.isEmpty()){
                    st.push(c);
                }
                else{
                    if(st.peek() == '(' && c == ')'){
                        st.pop();
                    }
                    else if(st.peek() == '[' && c == ']'){
                        st.pop();
                    }
                    else if(st.peek() == '{' && c == '}'){
                        st.pop();
                    }
                    else {
                        st.push(c);
                    }
                }
            }
            if(st.isEmpty()){
                answer++;
            }
            temp = temp.substring(1) + temp.charAt(0);
        }
        return answer;
    }
}