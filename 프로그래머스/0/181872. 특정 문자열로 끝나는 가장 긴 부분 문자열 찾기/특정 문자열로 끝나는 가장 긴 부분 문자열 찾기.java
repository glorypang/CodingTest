class Solution {
    public String solution(String myString, String pat) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int idx = myString.lastIndexOf(pat);
        for(int i =0  ; i< idx ; i++){
            sb.append(myString.charAt(i));
        }
        sb.append(pat);
        return sb.toString();
    }
}