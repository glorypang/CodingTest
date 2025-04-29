class Solution {
    public String solution(int age) {
        StringBuilder sb = new StringBuilder();
        String num = Integer.toString(age);
        for(char c : num.toCharArray()){
            sb.append((char)('a'+(c-'0')));
        }
        return sb.toString();
    }
}