class Solution {
    public int solution(int n) {
        int answer = 1;
        for(int i = 1 ; i<= n ; i++){
            String c = answer + "";
            //System.out.println(i + ", " + answer);

            if(answer%3 == 0){
                i--;
            }
            else if(c.contains("3")){
                i--;
            }
            answer++;
            
        }
        return answer-1;
    }
}