import java.util.*;
class Solution {
    class Server{
        int cnt;
        int time;
        
        Server(int c, int t){
            this.cnt = c;
            this.time = t;
        }
        
        void up(){
            this.time += 1;
        }
    }
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int sum = 0;
        Deque<Server> dq = new ArrayDeque<>();

        for(int i = 0; i < players.length; i++){
            int temp = players[i]/m;
            if(sum < temp){
                dq.offerLast(new Server(temp-sum, 0));
                sum += temp- sum;
            }
            
            if(!dq.isEmpty()){
                for(Server s : dq){
                    s.up();
                }
            }
            while (!dq.isEmpty() && dq.peekFirst().time == k) {
                Server s = dq.pollFirst();
                sum -= s.cnt; 
                answer += s.cnt;
            }
        }
        for(Server s : dq){
                answer += s.cnt;
        }
        return answer;
    }
}