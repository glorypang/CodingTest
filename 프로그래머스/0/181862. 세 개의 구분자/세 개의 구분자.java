import java.util.*;
class Solution {
    public String[] solution(String myStr) {
        String[] str = myStr.split("a|b|c");
        ArrayList<String> list = new ArrayList<>();
        for(String s : str){
            if(s.length() != 0){
                list.add(s);
            }
        }
        if(list.size() ==0) list.add("EMPTY");
        String[] answer = new String[list.size()];
        for(int i = 0 ; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}