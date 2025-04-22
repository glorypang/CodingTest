import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
        int cnt = strArr.length;
        String[] res = new String[cnt];
        int idx = 0;
        for(String str: strArr){
            if(idx%2==1){
                res[idx++] = str.toUpperCase();
            }
            else{
                res[idx++] = str.toLowerCase();
            }
        }
        
        return res;
    }
}