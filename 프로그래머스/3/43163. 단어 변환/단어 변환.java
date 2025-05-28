import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<String> q = new LinkedList<>();
        q.offer(begin);
        boolean[] visit = new boolean[words.length+1];
        
        
        int depth =0 ;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i< size; i++){                
                String cur = q.poll();

                if(cur.equals(target)){
                    return depth;
                }
                for(int j =0  ; j < words.length; j++){
                    String next = words[j];
                    if(isOneDifferen(cur, next) && !visit[j]){
                        visit[j] = true;
                        q.offer(next);
                   
                    }
                }
            }
            depth++;
        }
        
        return 0;
    }
    public boolean isOneDifferen(String a, String b){
        int cnt =0;
        for(int i = 0 ; i< a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                cnt++;
            }
            if(cnt >= 2)
                return false;
        }
        return true;
    }
}