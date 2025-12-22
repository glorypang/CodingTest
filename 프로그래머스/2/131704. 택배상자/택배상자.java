import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = order[0] ; i <= order.length; i++){
            q.offer(i);
        }

        int before;
        for(int i = 1; i < order[0]; i++){
            st.push(i);
        }  
        // Q : 4 5 
        // ST : 1 2 3  
        for(int i = 0 ; i < order.length; i++){
            int num = order[i];
            //  if(order[i-1] < order[i]){
            //     break;
            // }
            
//             System.out.println("num : " + num);
//             System.out.print("Q : ");
//             for(int c : q){
//                 System.out.print(c + " ");
//             }
//             System.out.println();
//             System.out.print("S : ");
            
//             for(int c : st){
//                 System.out.print(c + " ");
//             }
//             System.out.println();
//             System.out.println();
            
            
            boolean check = false;
            if(!q.isEmpty() &&q.peek() == num){
                answer++;
                q.poll();
                check = true;
            }
            
            if(!st.isEmpty() && st.peek() == num) {
                answer++;
                st.pop();
                check = true;
                
            }
            
            if(!check){
                while(!q.isEmpty() && q.peek() < num ){
                    st.push(q.poll());
                }
                if(q.peek() == num){
                    answer++;
                    q.poll();
                    check= true;
                }
            }
           
            if(!check) return answer;
            
        }

        
        return answer;
    }
}