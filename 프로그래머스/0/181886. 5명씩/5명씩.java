class Solution {
    public String[] solution(String[] names) {
        String[] answer = {};
        if(names.length % 5 == 0)
            answer = new String[names.length/5];
        else
            answer = new String[(names.length/5)+1];
        
        int cnt = 0;
        for(String s : names){
            if(cnt%5 == 0)
                answer[cnt/5] = s;
            cnt++;
        }
        return answer;
    }
}