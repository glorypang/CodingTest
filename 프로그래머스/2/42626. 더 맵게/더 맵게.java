import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : scoville){
            pq.offer(i);
        }
        while(pq.peek() < K){
            int n = pq.poll();
            int m = pq.poll();
            pq.offer(n + m*2);
            answer++;
            
            if(pq.size() == 1) break;
        }
        if(pq.peek() < K) return -1;
        return answer;
    }
}