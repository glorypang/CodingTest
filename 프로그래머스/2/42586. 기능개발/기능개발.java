import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] prog = progresses;
        int[] days = new int[102];
        boolean[] check = new boolean[prog.length];
        
        int day = 0;
        int std = 0;
        int sum = 0;
        ArrayList<Integer> list  = new ArrayList<>();
        
        while(true){
            day++;
            for(int i = 0 ; i< prog.length; i++){
                prog[i] += speeds[i];
            }
            for(int i = std ; i< prog.length; i++){ // 1 2 3 4 5 
                if(prog[i] >= 100){ 
                    check[i] = true;
                }
                else{
                    break;
                }
            }
            for(int i = 0 ; i < prog.length; i++){
            //System.out.print(check[i] +"" + prog[i]+ " ");
            }
            int cnt = 0;
            for(int i = std ; i< prog.length; i++){
                if(!check[i]) break;
                cnt++;
            }
            if(cnt >= 1){
                list.add(cnt);
                
                std += cnt;
                sum += cnt;                
            }
            //System.out.println("Day " + day + ", cnt " + cnt+ ", std " + std);
            
            if(sum == prog.length) break;
            
        }
        int len = list.size();
        int[] answer = new int[len];
        for(int i = 0  ; i < len; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}