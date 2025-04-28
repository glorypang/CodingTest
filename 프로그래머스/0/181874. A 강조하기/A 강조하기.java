class Solution {
    public String solution(String myString) {
        String answer = "";
        myString = myString.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(char c : myString.toCharArray()){
            if(c == 'a')
                sb.append(Character.toUpperCase(c));
            else sb.append(c);
        }
        
        return sb.toString();
    }
}