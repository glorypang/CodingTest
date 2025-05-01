import java.util.*;
class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        ArrayList<Integer> list  = new ArrayList<>();
        for(int m: array)
            list.add(m);
        Collections.sort(list, Collections.reverseOrder());
        int res = Integer.MAX_VALUE;
        for(int m : list){
            if(res >= Math.abs(n-m)){
                res = Math.abs(n-m);
                answer = m;
            }
        }
        return answer;
    }
}