import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        
        int answer = 1;
        int pos = routes[0][1];
        for(int[] r : routes){
            if(r[0] > pos){
                answer++;
                pos = r[1];
            }
            //System.out.println(r[0] + " " + r[1]);
        }
        
        return answer;
    }
}