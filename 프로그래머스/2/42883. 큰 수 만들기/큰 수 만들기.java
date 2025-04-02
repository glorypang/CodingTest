import java.util.*;
public class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int cnt = 0;
        Stack<Character> stac = new Stack<>();

        for (char c : number.toCharArray()) {
            while(!stac.isEmpty() && c > stac.peek() && cnt < k){
                stac.pop();
                cnt++;
            }
            stac.push(c);
        }
        while(cnt < k){
            stac.pop();
            cnt++;
        }
        
        StringBuilder sb = new StringBuilder();
        for (char c : stac) {
            sb.append(c);
        }

        return sb.toString();

    }
}
