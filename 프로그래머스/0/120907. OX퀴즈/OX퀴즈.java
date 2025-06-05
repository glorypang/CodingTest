class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        int idx = 0;
        for(String str : quiz){
            String[] s = str.split(" ");
            int sum = 0;
            if(s[1].equals("+"))
                sum = Integer.parseInt(s[0]) + Integer.parseInt(s[2]);
            else{
                sum = Integer.parseInt(s[0]) - Integer.parseInt(s[2]);
            }
            
            if(Integer.toString(sum).equals(s[4])){
                answer[idx++] = "O";
            }
            else{
                answer[idx++] = "X";
            }
        }
        return answer;
    }
}