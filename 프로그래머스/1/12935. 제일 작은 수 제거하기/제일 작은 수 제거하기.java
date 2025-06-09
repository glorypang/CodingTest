import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1){
            return new int[]{-1};
        }
        int[] temp = arr.clone();
        Arrays.sort(temp);
        int num = temp[0];
        
        List<Integer> list =new ArrayList<>();
        
        for(int i = 0 ; i< arr.length; i++){
            if(arr[i] != num){
                list.add(arr[i]);
            }
        }
        int len = list.size();
        int[] answer = new int[len];
        for(int i =0  ; i< len ; i++){
            answer[i] = list.get(i);
        }
        
        
        return answer;
    }
}