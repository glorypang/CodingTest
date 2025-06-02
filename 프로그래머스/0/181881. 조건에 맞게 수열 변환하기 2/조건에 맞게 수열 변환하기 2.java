class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int[] temp = arr;
        while(true){
            int cnt  = 0;
            for(int i = 0; i < arr.length; i++){
                if(temp[i] >= 50 && temp[i]%2 == 0){
                    temp[i] /= 2;
                }else if(temp[i] < 50 && temp[i]%2 == 1){
                    temp[i] = temp[i] * 2 + 1;
                }
                else{
                    cnt++;
                }
            }
            if(cnt == arr.length)
                return answer;
            answer++;
        }
    }
}