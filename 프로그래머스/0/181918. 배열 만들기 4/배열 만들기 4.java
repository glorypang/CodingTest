import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] stk = {};

        for(int i = 0 ; i < arr.length; i++){
            if(dq.isEmpty()){
                dq.offerLast(arr[i]);
            }
            else{
                if(dq.peekLast() < arr[i]){
                    dq.offerLast(arr[i]);
                }
                else{
                    dq.pollLast();
                    i--;
                }
            }
        }
        int len = dq.size();
        stk = new int[len];
        int i = 0;
        for(int n : dq){
            stk[i++] = n;
        }
        return stk;
    }
}