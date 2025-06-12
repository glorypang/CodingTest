import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        List<Integer> list =new ArrayList<>();
        for(int n : score){
            list.add(n);
        }
        Collections.sort(list, Collections.reverseOrder());        
        int idx =0;
        for(int i = 1 ;i <= list.size()/m; i++){
            answer += list.get(m*i -1)*m;
        }

       
        return answer;
    }
}