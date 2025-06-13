import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int idx = 0;
        ArrayList<Integer> list = new ArrayList<>();
        int cntZ = 0;
        for(int n : win_nums){
            list.add(n);
        }
        
        int cnt = 0;
        for(int n : lottos){
            if(n == 0 ) cntZ++;
            if(list.contains(n)){
                cnt++;
            }
        }
        if(cntZ == 6){
            return new int[]{1,6};
        }
        if(cnt ==0){
            return new int[]{6,6};
        }
        answer = new int[]{7-(cnt+cntZ), 7-cnt};
        return answer;
    }
}