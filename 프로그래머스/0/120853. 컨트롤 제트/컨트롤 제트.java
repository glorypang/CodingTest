import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        String[] ss = s.split(" ");
        for(String str : ss){
            if(str.equals("Z"))
                st.pop();
            else{
                st.push(Integer.parseInt(str));
            }
        }
        for(int n : st){
            answer +=n;
        }
        return answer;
    }
}