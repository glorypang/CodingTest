import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < len; i++){
            int cnt = 0;
            int j;
            for(j = i+1; j <len; j++){
                if(prices[i] <= prices[j]){
                    cnt++;
                }
                else{
                    cnt++;
                    break;
                }
            }
            map.put(i, cnt);
            
        }
        int[] answer = new int[map.size()];
        for(int i = 0 ; i < len ;i++){
            answer[i] = map.get(i);
        }
        
        return answer;
    }
}