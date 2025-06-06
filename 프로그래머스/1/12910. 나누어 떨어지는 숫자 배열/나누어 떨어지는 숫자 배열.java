import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i <arr.length; i++){
            if(arr[i]%divisor  == 0){
                list.add(arr[i]);
            }
        }
        Collections.sort(list);
        int len = list.size();
        if(len == 0){
            return new int[]{-1};
        }
        answer = new int[len];
        for(int i = 0 ; i < len ; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}