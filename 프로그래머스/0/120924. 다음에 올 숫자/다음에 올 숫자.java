class Solution {
    public int solution(int[] common) {
        int answer = 0;
        
        int diff1 = common[1] - common[0];
        int diff2 = common[2] - common[1];
        if(diff2 == diff1) {
            answer = common[0] + common.length*diff1;
        }
        else{
            int diff = common[1]/common[0];
            
            answer = common[0] * (int)Math.pow(diff, common.length);
        }
        return answer;
    }
}