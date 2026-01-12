import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq =new PriorityQueue<>(Collections.reverseOrder());
        
        int sol = n;
        for(int e : enemy){
            sol -= e;
            pq.add(e);
            
            if(sol < 0){
                if(k == 0) break;
                
                sol += pq.poll();
                k--;
            }
            answer++;
        }
        return answer;
    }
}