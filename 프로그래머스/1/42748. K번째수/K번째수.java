import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        
        for(int[] com : commands){
            int len = com[1] - com[0] +1;
            int[] temp = new int[len];
            for(int i = com[0]-1; i < com[1]; i++){
                temp[i - com[0]+1] = array[i];
            }
            Arrays.sort(temp);
            answer[idx++] = temp[com[2]-1];
        }
        return answer;
    }
}