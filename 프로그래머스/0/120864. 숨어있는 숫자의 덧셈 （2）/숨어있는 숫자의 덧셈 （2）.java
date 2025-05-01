class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String[] str = my_string.split("[a-zA-Z]");
        for(String s : str){
            if(s.length() >=1)
                answer += Integer.parseInt(s);
        }
        return answer;
    }
}