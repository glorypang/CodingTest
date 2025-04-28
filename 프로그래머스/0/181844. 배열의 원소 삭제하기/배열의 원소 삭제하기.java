import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        ArrayList<Integer> array = new ArrayList<>();
        for(int i = 0 ; i < arr.length ; i++){
            array.add(arr[i]);
            for(int j = 0 ; j < delete_list.length; j++){
                if(arr[i] == delete_list[j])
                   array.remove(array.size()-1); 
            }
        }
        int[] answer = new int[array.size()];
        for(int i = 0 ; i< array.size();i++){
            answer[i] = array.get(i);
        }

        return answer;
    }
}