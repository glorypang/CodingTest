class Solution {
    public int[] solution(int n, int k) {
        int[] answer = new int[n/k];
        int idx = 0;
        for(int i = k ; i <= n ; i+=k){
            if(i%k == 0)
                answer[idx++] = i;
        }
        return answer;
    }
}