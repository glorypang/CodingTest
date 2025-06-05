import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        for(int i = l; i <= r ;i++){
            String temp = i + "";
            if(temp.matches("^[50]+$")){
                list.add(i);
            }
        }
        
        int len = list.size();
        if(len == 0){
            return new int[]{-1};
        }
        answer = new int[len];
        for(int i =0 ; i < len; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}