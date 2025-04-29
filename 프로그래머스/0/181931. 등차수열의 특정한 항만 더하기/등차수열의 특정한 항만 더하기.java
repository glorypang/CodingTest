class Solution {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        int num = a;
        for(int i = 0 ; i < included.length; i++){
            if(included[i])
                answer += num;
            num+=d;
        }
        return answer;
    }
}