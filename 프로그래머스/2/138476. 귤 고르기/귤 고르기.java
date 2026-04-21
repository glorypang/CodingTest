import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : tangerine)
            map.put(n, map.getOrDefault(n, 0)+1);
        List<Integer> sorted = new ArrayList<>(map.keySet());
        Collections.sort(sorted, (o1, o2)-> map.get(o2) - map.get(o1));
        
        int sum = 0;
        int cnt = 0;
        for(int n: sorted){
            sum +=map.get(n);
            cnt++;
            if(sum >= k){
                return cnt;
            }
        }
        return 0;
    }
}