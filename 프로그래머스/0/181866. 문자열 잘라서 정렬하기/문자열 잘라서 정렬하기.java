import java.util.*;
class Solution {
    public String[] solution(String myString) {
        String[] answer = myString.split("x");
        List<String> str = new ArrayList<>();
        
        for(String s : answer){
            if(!s.isEmpty()){
                str.add(s);
            }
        }
        Collections.sort(str);        
        return str.toArray(new String[0]);
    }
}