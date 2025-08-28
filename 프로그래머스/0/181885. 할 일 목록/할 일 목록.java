import java.util.*;
class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        String[] answer = {};
        List<String> list = new ArrayList<>();
        
        int idx = 0;
        for(String s : todo_list){
            if(!finished[idx++]){
                list.add(s);
            }
        }
        int len = list.size();
        answer = new String[len];
        for(int i = 0 ; i< len ; i++){
            answer[i] = list.get(i);
        }
        System.out.println(list);
        return answer;
    }
}