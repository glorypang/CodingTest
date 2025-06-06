class Solution {
    public String solution(String phone_number) {
        int len =phone_number.length() -4;
        if(phone_number.length() == 4){
            return phone_number;
        }
        String answer = "";
        String star = phone_number.substring(0, len);
        answer = star.replaceAll("[0-9]", "*") +phone_number.substring(len);
        
        return answer;
    }
}