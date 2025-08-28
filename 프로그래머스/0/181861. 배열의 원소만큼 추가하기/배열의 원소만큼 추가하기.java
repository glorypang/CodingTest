import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        for(int n : arr){
            for(int i = 0 ; i < n ; i++){
                list.add(n);
            }
        }
        int len = list.size();
        answer = new int[len];
        for(int i = 0 ; i< len; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}