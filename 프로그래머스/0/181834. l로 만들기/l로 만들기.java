class Solution {
    public String solution(String myString) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(char c : myString.toCharArray()){
            if(c < 'l')
                sb.append('l');
            else
                sb.append(c);
        }
        return sb.toString();
    }
}