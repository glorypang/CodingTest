import java.util.*;
class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        for(String str : intStrs){
            String temp = str.substring(s, s+l);
            int n = Integer.parseInt(temp);
            if(n > k)
                list.add(n);
        }
        answer = new int[list.size()];
        for(int i =0 ; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}