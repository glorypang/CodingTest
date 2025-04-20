class Solution {
    public String solution(String my_string) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(char c: my_string.toCharArray()){
            if(Character.isUpperCase(c)){
                sb.append(Character.toLowerCase(c));
            }
            else
                sb.append(Character.toUpperCase(c));

        }
        return sb.toString();
    }
}