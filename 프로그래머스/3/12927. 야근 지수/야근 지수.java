import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(int w : works){
            pq.offer(w);
        }
        
        for(int i = 0 ; i < n ;i++){
            if(pq.peek() == 0) return 0;
            pq.offer(pq.peek()-1);
            pq.poll();
            
            // for(int p : pq){
            //     System.out.print(p + " ");
            // }
            // System.out.println();
        }
            for(int p : pq){
                answer += Math.pow(p,2);
            }
        
        
        return answer;
    }
}