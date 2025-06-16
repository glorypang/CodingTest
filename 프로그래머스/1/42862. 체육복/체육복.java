import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        Map<Integer, Boolean> map = new HashMap<>();
        
        Arrays.sort(lost);
        List<Integer> list = new ArrayList<>();
        for(int p : lost){
            list.add(p);
        }
        for(int res : reserve){
            map.put(res, false);
        }
        for(int p : lost){
            if(map.containsKey(p)){
                map.put(p, true);
                answer++;
                System.out.println("0");
                list.remove((Integer) p);
            }
        }
        
        for(int p : list){
            if(map.containsKey(p-1) && !map.get(p-1)){
                map.put(p-1, true);
                answer++;
                System.out.println("1");
            }
            else if(map.containsKey(p+1) && !map.get(p+1)){
                map.put(p+1, true);
                answer++;
                System.out.println("2");
                
            }
        }
        
        return answer;
    }
}