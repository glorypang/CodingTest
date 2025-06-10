class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        for(int i =1  ; i< food.length; i++){
            for(int j = 0; j < food[i]/2; j++){
                sb.append(i+"");
            }
        }
        StringBuilder temp = new StringBuilder(sb.toString());
        temp.reverse();
        sb.append("0");
        
        answer = sb.toString() + temp.toString();
        //System.out.println(answer);
        return answer;
    }
}