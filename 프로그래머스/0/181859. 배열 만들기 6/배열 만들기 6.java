import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0 ; i< arr.length; i++){
            if(i < arr.length){
                if(dq.isEmpty()){
                    dq.offerLast(arr[i]);
                }
                else{
                    if(arr[i] == dq.peekLast()){
                        dq.pollLast();
                    }
                    else{
                        dq.offerLast(arr[i]);
                    }
                }
            }
        }
        int len = dq.size();
        if(len == 0){
            return new int[]{-1};
        }
        answer = new int[len];
        for(int i = 0 ; i < len ; i++){
            answer[i] = dq.poll();
        }
        return answer;
    }
}