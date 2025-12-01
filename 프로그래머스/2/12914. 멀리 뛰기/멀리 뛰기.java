import java.util.*;
class Solution {
    public long solution(int n) {
        long answer = 1;

        List<Integer> list =new ArrayList<>();
        list.add(0); // 0
        list.add(1); // 1
        list.add(2); // 2
        for(int i = 3 ; i <= n ; i++){
            list.add((list.get(i-1) + list.get(i-2))%1234567);
        }
        
        return list.get(n);
    }
}
