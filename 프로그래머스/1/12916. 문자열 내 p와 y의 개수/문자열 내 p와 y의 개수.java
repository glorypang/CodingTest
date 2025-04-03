class Solution {
    boolean solution(String s) {
        int pCnt = 0;
        for(char c : s.toCharArray()){
            if(c == 'P' || c == 'p') pCnt++;
            else if(c == 'Y' || c == 'y') pCnt--;
        }
        return pCnt == 0 ? true : false;
    }
}