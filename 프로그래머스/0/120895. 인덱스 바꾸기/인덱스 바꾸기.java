class Solution {
    public String solution(String my_string, int num1, int num2) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        char[] arr = my_string.toCharArray();
        char temp = arr[num1];       
        arr[num1] = arr[num2];
        arr[num2] = temp;
        
        for(char c : arr){
            sb.append(c);
        }
        
        return sb.toString();
    }
}