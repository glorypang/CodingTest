import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Deque<Character> str = new LinkedList<>();
        for(Character a : s.toCharArray()){
            str.addLast(a);
        }
        
        for(int i = 0; i < s.length(); i++){
            Stack<Character> st = new Stack<>();
            StringBuilder sb = new StringBuilder();
            for(Character c : str){
                sb.append(c);
            }
            // System.out.println(sb);
                
            
            for(int j = 0; j < s.length(); j++){
                if(st.isEmpty()){
                    st.push(sb.charAt(j));
                }
                else{
                    if(st.peek() == '(' && sb.charAt(j) == ')') st.pop();
                    else if(st.peek() == '[' && sb.charAt(j) == ']') st.pop();
                    else if(st.peek() == '{' && sb.charAt(j) == '}') st.pop();
                    else {
                        st.push(sb.charAt(j));
                    }
                }
            }
            
            // for(Character c : st){
            //     System.out.println(c);
            // }
            if(st.isEmpty()) answer++;
            
            str.addLast(str.removeFirst());

        }
        return answer;
    }
}