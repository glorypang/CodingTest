import java.util.*;
class Solution {
    public String solution(String my_string) {
        String answer = "";
        char[] arr = my_string.toLowerCase().toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}