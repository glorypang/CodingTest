class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long sum = 0;
        for(long i = 1; i<=count; i++){
            sum += price*i;
        }
        return sum - money > 0 ? sum - money : 0;
    }
}