import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int m : works)
            pq.offer(m);
        for(int i = 0 ; i < n ; i++){
            int work = pq.poll();
            
            if(work == 0) return 0;
            pq.add(work -1);
        }
        for(int m : pq){
            answer += Math.pow(m,2);
        }
        return answer;
    }
}