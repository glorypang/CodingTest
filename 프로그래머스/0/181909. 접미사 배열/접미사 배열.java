import java.util.*;
class Solution {
    public String[] solution(String my_string) {
        String[] answer;
        ArrayList<String> arr = new ArrayList<>();
        for(int i = 1 ; i <= my_string.length(); i++){
            String str = my_string.substring(my_string.length()-i);
            arr.add(str);
        }
        
        answer = new String[arr.size()];
        for(int i = 0 ; i< arr.size(); i++)
            answer[i] = arr.get(i);
        
        Arrays.sort(answer);
        return answer;
    }
}