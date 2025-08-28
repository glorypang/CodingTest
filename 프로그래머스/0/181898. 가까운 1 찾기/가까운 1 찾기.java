class Solution {
    public int solution(int[] arr, int idx) {
        int answer = 0;
        boolean check = false;
        for(int i = idx ; i < arr.length; i++){
            if(arr[i] == 1 && !check) {
                check = true;
                answer = i;
            }
        }
        if(check) return answer;
        return -1;
    }
}