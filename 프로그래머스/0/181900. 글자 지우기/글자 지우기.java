import java.util.*;
class Solution {
    public String solution(String my_string, int[] indices) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(indices);
        sb.append(my_string);
        for(int i = indices.length-1 ; i >=0; i--){
            sb.delete(indices[i], indices[i]+1);
        }
        return sb.toString();
    }
}