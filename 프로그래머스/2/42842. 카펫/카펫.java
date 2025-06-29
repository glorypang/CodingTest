class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        for(int i =1 ; i <= yellow; i++){
            if(yellow % i == 0){
                int rowY = i;
                int colY = yellow/i;
                int cnt = rowY*2 + colY*2 +4;
                if(cnt == brown){
                    return new int[]{colY+2, rowY+2};
                }
            }
        }
        return answer;
    }
}