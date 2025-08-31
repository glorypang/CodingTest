import java.util.*;
class Solution {
    public String solution(String my_string, int[] indices) {
        String answer = "";
        Arrays.sort(indices);
        char[] ch = my_string.toCharArray();
        for(int i = 0 ; i < ch.length; i++){
            if(Arrays.binarySearch(indices,i) < 0)
                answer += ch[i] + "";
        }
        return answer;
    }
}