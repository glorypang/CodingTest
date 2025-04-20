class Solution {
    public int[] solution(int[] array) {
        int[] answer = {};
        int max = Integer.MIN_VALUE;
        int idx = 0;        
        for(int i = 0 ; i< array.length; i++){
            if(array[i] >= max){
                idx = i;
                max = array[i];
                answer= new int[]{max, idx};
                
            }
        }
        return answer;
    }
}