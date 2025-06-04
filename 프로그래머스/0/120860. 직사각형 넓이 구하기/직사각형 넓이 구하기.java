import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        Arrays.sort(dots, (a,b) ->{
            if(a[0] == b[0]){
                return Integer.compare(a[1], b[1]);
            }
            else{
                return Integer.compare(a[0], b[0]);
            }
        });
        
        answer = Math.abs(dots[0][1] - dots[1][1]) * Math.abs(dots[1][0] - dots[2][0]); 
        
        return answer;
    }
}