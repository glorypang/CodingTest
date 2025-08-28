import java.util.*;
class Solution {
    public String[] solution(String[] strArr) {
        String[] answer = {};
        
        List<String> list = new ArrayList<>();
        for(String str : strArr){
            if(!str.contains("ad")){
                list.add(str);
            }
        }
        int len = list.size();
        answer = new String[len];
        for(int i = 0 ; i < len ; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}