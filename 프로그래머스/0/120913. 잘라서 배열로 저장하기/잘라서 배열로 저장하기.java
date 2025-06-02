class Solution {
    public String[] solution(String my_str, int n) {
        String[] answer = new String[(int)Math.ceil((float)my_str.length()/n)];
        int idx = 0;
        while(idx < answer.length-1){
            int start = idx*n;
            int end = (idx+1)*n;
            answer[idx] = my_str.substring(start, end);
            idx++;
        }
        answer[idx] = my_str.substring((idx)*n);
        return answer;
    }
}