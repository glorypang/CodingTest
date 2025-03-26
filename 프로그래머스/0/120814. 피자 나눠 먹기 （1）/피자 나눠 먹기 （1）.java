class Solution {
    public int solution(int n) {
        int answer = 0;
        return n%7 > 0? n/7 +1 : n/7;
    }
}