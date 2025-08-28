class Solution {
    public String solution(int age) {
        String answer = "";
        StringBuilder sb =new StringBuilder();
        while(age != 0){
            int n = age%10;
            age /= 10;
            
            sb.append((char)(97+n));
        }
        return sb.reverse().toString();
    }
}