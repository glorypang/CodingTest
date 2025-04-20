class Solution {
    public int[] solution(int[] arr, int n) {
        int[] answer = arr;
        int len =  arr.length;
        if(len %2 == 0){
            for(int i = 1 ; i < len ; i +=2){
                answer[i] = answer[i] +n;
            }
        }
        else {
            for(int i = 0 ; i < len ; i +=2){
                answer[i] = answer[i] +n;
            }
        }
        return answer;
    }
}