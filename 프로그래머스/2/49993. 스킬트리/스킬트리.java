import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        
        
        for(String str : skill_trees){
            Deque<Character> dq = new LinkedList<>();     
        Deque<Character> dq1 = new LinkedList<>();     
            for(char c : skill.toCharArray()){
                dq.offerLast(c);
                dq1.offerLast(c);
            }
            boolean check = true;
            for(int i = 0 ; i < str.length(); i++){
                char c  = str.charAt(i); //B
                if(dq1.contains(c)){// B
                    if(c == dq.peekFirst()){
                        dq.pollFirst();
                    }
                    else{
                        //System.out.print(c);                
                        check = false;
                        break;
                    }
                }
            }
            if(check) {
                answer++;
                //System.out.println("answer = " + str);
        
            }
        }
        return answer;
    }
}