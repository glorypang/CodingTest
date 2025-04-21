import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
        String[] answer = {};
        List<String> arr = new ArrayList<String>();
        for(String str : strArr){
            if(str.indexOf("ad") >= 0){
                continue;
            }
            else {
                arr.add(str);
            }
        }
        int len = arr.size();
        answer = new String[len];
        
        for(int i = 0 ; i< len ; i++){
            answer[i] = arr.get(i);
        }
        return answer;
    }
}