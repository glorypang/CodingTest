import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean[] visit = new boolean[words.length];
        Queue<String> q = new LinkedList<>();
        q.offer(begin);
        int depth = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i =0 ; i < size; i++){
                String str = q.poll();
                
                if(str.equals(target)){
                    return depth;
                }
                
                for(int j = 0 ; j <words.length; j++){
                    if(!visit[j] && isOneDifferent(str, words[j])){
                        visit[j] = true;
                        q.offer(words[j]);
                    }
                }
            }
            depth++;
        }
        return 0;
    }
    public boolean isOneDifferent(String s1, String s2){
        int cnt = 0;
        for(int i = 0 ; i <s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                cnt++;
            }
            if(cnt >= 2){
                return false;
            }
        }
        return true;
    }
}