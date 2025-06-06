class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for(String str : babbling){
            String temp = str.replace("aya", "");
            temp = temp.replace("ye", "");
            temp = temp.replace("woo", "");
            temp = temp.replace("ma", "");
            
            System.out.println(temp);
            
            if(str.matches("^(aya|ye|woo|ma)+$")){
                answer++;
            }
            
            if(temp.length() == 0){
                // answer++;
            }
        }
        return answer;
    }
}