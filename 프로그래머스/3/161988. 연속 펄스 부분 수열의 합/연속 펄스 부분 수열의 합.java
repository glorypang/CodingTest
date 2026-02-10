import java.util.*;
class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        
        boolean check = false; // 음수면 false
        if(sequence[0] >= 0) check = true; 
        else check = false;
        
        int[] temp1= sequence.clone();
        int[] temp2= sequence.clone();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2- o1);
        long sum = 0;
        // -1, 1, -1, 1
        for(int i = 0 ; i < sequence.length; i++){
            if(i % 2 == 0)
                temp1[i] *= -1;
            else 
                temp1[i] *= 1;
        }
        for(int n : temp1){
            // System.out.print(n + " ");
        }
        // System.out.println();
        long cur = temp1[0];
        long best = temp1[0];
        for(int i = 1 ; i < sequence.length; i++){
            cur = Math.max(temp1[i], cur+temp1[i]);
            best = Math.max(best, cur);
        }
        // System.out.println(best);
        
        // 1, -1, 1, -1
        for(int i = 0 ; i < sequence.length; i++){
            if(i % 2 == 0)
                temp2[i] *= 1;
            else 
                temp2[i] *= -1;
        }
        for(int n : temp2){
            // System.out.print(n + " ");
        }
        // System.out.println();
        cur = temp2[0];
        long best2 = temp2[0];
        for(int i = 1 ; i < sequence.length; i++){
            cur = Math.max(temp2[i], cur+temp2[i]);
            best2 = Math.max(best2, cur);
        }
        // System.out.println(best);
//         for(int i = 0 ; i < sequence.length ; i++){
//             sum += Math.abs(sequence[i]);
//             if(sequence[i] >= 0){  
//                 if(!check){ // 이 전 음수고 지금이 양수
//                 }
//                 else if(i > 0 && check){ // 이 전이 양수고 지금이 양수
//                     sum -= Math.abs(sequence[i-1]);
//                     pq.offer(sum);
//                     // sum = 0;
//                 }
//                 check = true;
//             }
//             else { // 이 전이 양수고 지금 음수
//                 if(check){
                    
//                 }
//                 else if(i > 0 && !check){
//                     sum -= Math.abs(sequence[i]);
//                     pq.offer(sum);
//                     // sum = 0;
//                 }
//                 check = false;
//             }
//             System.out.println(sequence[i] + " "+ sum);
//         }

        // for(int n : pq){
        //     System.out.println(n);
        // }
        return Math.max(best, best2);
    }
}