class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String temp = a + "" + b;
        answer = Integer.parseInt(temp);
        return answer >= 2*a*b ? answer: 2*a*b;
    }
}