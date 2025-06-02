import java.util.*;
class Solution {
    public String[] solution(String[] str_list) {
        String[] answer = {};
        Stack<String> st = new Stack<>();
        boolean check = false;
        for(String str : str_list){
            
            if(str.equals("r") && !check){
                st.clear();
                check = true;
            }else if(str.equals("l") && !check){
                check = true;
                break;                
            }else{
                st.push(str);
            }
        }
        if(!check){
            return answer;
        }
        answer = new String[st.size()];
        int idx = 0;
        for(String str : st){
            answer[idx++] = str;
        }
        
        return answer;
    }
}