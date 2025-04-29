class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[1 + (num_list.length-1)/n];
        int idx = 0;
        for(int i = 0; i < num_list.length;  i +=n){
            answer[idx++] = num_list[i];
        }
        return answer;
    }
}