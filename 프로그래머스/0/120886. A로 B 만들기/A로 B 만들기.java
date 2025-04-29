import java.util.*;
class Solution {
    public int solution(String before, String after) {
        int answer = 0;
        char[] b = before.toCharArray();
        Arrays.sort(b);
        String be = new String(b);
        
        char[] a = after.toCharArray();
        Arrays.sort(a);
        String af = new String(a);
        
        if(be.equals(af)) answer = 1;
        else answer = 0;
        
        return answer;
    }
}