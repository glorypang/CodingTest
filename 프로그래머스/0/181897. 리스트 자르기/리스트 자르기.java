import java.util.*;
class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int[] answer = {};
        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];
        
        if(n == 1){
            answer = Arrays.copyOfRange(num_list, 0 , b+1);
        }
        else if(n == 2){
            answer = Arrays.copyOfRange(num_list, a, num_list.length);
        }
        else if(n== 3){
            answer = Arrays.copyOfRange(num_list, a, b+1);
        }
        else{
            List<Integer> list =new ArrayList<>();
            for(int i =a ; i<= b ; i+=c){
                list.add(num_list[i]);
            }
            int len = list.size();
            answer = new int[len];
            for(int i = 0 ; i < len ; i++){
                answer[i] = list.get(i);
            }
        }
        return answer;
    }
}