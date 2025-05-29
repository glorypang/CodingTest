import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visit = new boolean[words.length];
        Queue<String> q = new LinkedList<>();
        q.offer(begin);
        int depth =0 ;
        
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size-- > 0 ){
                String cur = q.poll();
                
                if(cur.equals(target)){
                    return depth;
                }
                for(int i = 0; i < words.length; i++){
                    if(!visit[i] && isOne(cur, words[i])){
                        visit[i] = true;
                        q.offer(words[i]);
                    }
                }
            }
            depth++;
        }
        return 0;
    }
    public boolean isOne(String s1, String s2){
        int cnt = 0 ;
        for(int i = 0 ; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                cnt++;
            }
            if(cnt>1){
                return false;
            }
        }
        return true;
    }
}