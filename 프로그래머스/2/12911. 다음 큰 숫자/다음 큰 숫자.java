class Solution {
    public int solution(int n) {
        int init = binary(n);
        
        for(int i = n+1 ; i< 10000000; i++){
            if(init == binary(i)){
                return i;
            }
        }
        
        int answer = 0;
        return answer;
    }
    public int binary(int nn){
        String s = Integer.toBinaryString(nn);
        int cnt = 0;
        for(char c : s.toCharArray()){
            if(c == '1'){
                cnt++;
            }
        }
        return cnt;
    }
}