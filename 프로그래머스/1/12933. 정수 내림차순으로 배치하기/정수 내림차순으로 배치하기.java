import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        StringBuilder sb = new StringBuilder();
        List<Long> list = new ArrayList<>();
        while(n >0){
            list.add(n%10);
            n /= 10;
        }
        Collections.sort(list);
        Collections.reverse(list);

        for(int i =0  ; i< list.size();i++){
            sb.append(list.get(i));
        }
        
        return Long.parseLong(sb.toString());
    }
}