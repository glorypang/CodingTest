import java.util.*;
class Solution {
    public int[] solution(int[][] score) {
        int[] answer = {};
        double[] list = new double[score.length];
        int[] rank = new int[score.length];

        int idx = 0;
        for(int[] s : score){
            double avg = ((double)s[0]+(double)s[1])/(double)2;
            list[idx++] = avg;
        }
        
        Arrays.fill(rank, 1);
        for(int i = 0 ; i< rank.length; i++){
            for(int j = 0 ; j < rank.length; j++){
                if(i != j && list[i] < list[j]){
                    rank[i]++;
                }
            }
        }
        
        return rank;
    }
}