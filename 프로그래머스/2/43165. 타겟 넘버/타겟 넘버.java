class Solution {
    int cnt = 0;
    int[] number;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        number = numbers;
        dfs(0, 0, target);
        return cnt;
    }
    void dfs(int idx, int sum, int target){
        if(target == sum && idx == number.length) {
            cnt++;
            return; 
        }
        if(idx > number.length-1) return;
        
        dfs(idx+1, sum + number[idx], target);
        dfs(idx+1, sum - number[idx], target);
        
    }
}