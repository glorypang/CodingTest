class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int w = 0;
        int h = 0;
        for(int i = 1 ; i <= yellow; i++){
            if(yellow%i ==0){
                h = i;
                w = yellow/i;
                
                int total = 4 + h*2 + w*2;
                if(total == brown){
                    answer[0]= h+2;
                    answer[1]= w+2; 
                }
            }
        }
        return answer;
    }
}