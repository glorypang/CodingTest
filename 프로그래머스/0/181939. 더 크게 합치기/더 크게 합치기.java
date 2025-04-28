class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String A = a + "" + b;
        String B = b + "" + a;
        int tempA = Integer.parseInt(A);
        int tempB = Integer.parseInt(B);
        return tempA >= tempB ? tempA : tempB;
    }
}