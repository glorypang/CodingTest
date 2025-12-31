import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Deque<Character> dq = new ArrayDeque<>();
        char[] chs = number.toCharArray();
        int cnt = 0;
        for(char c : chs){
            if(dq.isEmpty())
                dq.offerLast(c); // 32
            else if(k > cnt){ //7
                while(cnt <k &&!dq.isEmpty() && dq.peekLast()-'0' < c-'0'){
                    dq.pollLast();
                    cnt++;
                }
                dq.offerLast(c);
            }
            else
                dq.offerLast(c); 
            // System.out.print("CNT : " + cnt + "개, ");
            // for(char n : dq){
            //     System.out.print(n +" ");
            // }
            // System.out.println();
        }
        
        while(k >cnt){
            dq.pollLast();
            cnt++;
        }
        StringBuilder sb= new StringBuilder();
        for(char n : dq){
            sb.append(n);
        }
        return sb.toString();
    }
}