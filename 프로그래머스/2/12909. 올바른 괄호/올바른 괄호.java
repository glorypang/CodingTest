class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int leftCnt = 0; // 왼쪽 괄호의 수
        int rightCnt = 0; // 오른쪽 괄호의 수
        
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(')
                leftCnt++;
            else
                rightCnt++;
            if(rightCnt > leftCnt) return false;
            
        }
        if(leftCnt != rightCnt) return false;

        return answer;
    }
}