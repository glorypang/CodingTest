class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        String str = myString.toLowerCase();
        
        if(str.indexOf(pat.toLowerCase()) >=0){
            return 1;
        }
        else{
            return 0;
        }
    }
}