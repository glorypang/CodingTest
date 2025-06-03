class Solution {
    public int solution(int[] numbers, int k) {
        int num = k*2 -1;
        //[1, 2, 3] 5 3
        int answer = numbers[(num-1)%numbers.length];
        return answer;
    }
}