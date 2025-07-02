import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        int start = 0;
        int end = people.length-1;
        while(true){
            if(start > end){
                    break;
            }
            if(people[start] + people[end] <= limit) {
                start++;
                end--;
            }
            else if(people[start] + people[end] > limit){
                end -= 1;
            }
            answer++;
            
        }
        return answer;
    }
}