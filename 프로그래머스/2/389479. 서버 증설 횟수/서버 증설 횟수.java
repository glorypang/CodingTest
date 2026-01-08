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
        
        
        int std = 0;
        boolean check = false;
        int cnt = 0;
        int cnt1 = 0;
//         for(int n : players){
//             System.out.print(n + " ");
//             int tmp = n/m;
//             if(cnt > 0) {
//                 cnt--; // 3
                
//                 if(cnt1 == k-1){
//                     std--;
//                     cnt1 = 0;
//                 }
//                 else cnt1++;
//             }
            
//             if(tmp > std){ // 1
//                 answer += tmp-std; // 1
//                 std = tmp; 
//                 check = true;
//                 cnt +=(k); // 7
//             }
//             System.out.println(cnt + " " + std + " ");
            
//         }
        int[] arr = new int[30];
        Deque<Server> dq = new ArrayDeque<>();
        int sum = 0;
        for(int i = 0; i < players.length; i++){
            int temp = players[i]/m;
            // System.out.println(players[i] + " : ");
            
            if(sum < temp){
                dq.offerLast(new Server(temp-sum, 0));
                sum += temp- sum;
            }
            
            if(!dq.isEmpty()){
                for(Server s : dq){
                    s.up();
                }
            }
            // for(Server s : dq){
            //     System.out.println("Q - " + s.cnt + " " + s.time);
            // }
            // System.out.println("s: " + sum + " ans: " + answer);
            
            while (!dq.isEmpty() && dq.peekFirst().time == k) {
                Server s = dq.pollFirst();
                sum -= s.cnt; 
                answer += s.cnt;
            }
            
            //System.out.println("-------");
            
//             System.out.print(players[i] + " : ");
//             if(temp > 0 && temp != arr[i]){
//                 for(int j = i; j < i+k ; j++){
//                     if(temp >= arr[j])
//                         arr[j] += temp- arr[j];
//                 }
//             }
            
//             for(int n : arr){
//                 System.out.print(n + " ");
//             }
//             System.out.println();
        }
        for(Server s : dq){
                answer += s.cnt;
        }
        return answer;
    }
}