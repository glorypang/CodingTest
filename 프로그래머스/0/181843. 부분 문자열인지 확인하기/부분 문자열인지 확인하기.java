class Solution {
    public int solution(String my_string, String target) {
        int answer = 0;
        answer = my_string.indexOf(target);
        return answer == -1? 0 : 1;
    }
}