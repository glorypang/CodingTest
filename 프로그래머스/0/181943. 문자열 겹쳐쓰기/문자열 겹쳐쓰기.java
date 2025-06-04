class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        int len = overwrite_string.length()+s > my_string.length() ? overwrite_string.length()+s :  my_string.length();
        
        char[] chars = my_string.toCharArray();
        
        for(int i = s ; i < s+overwrite_string.length(); i++){
            chars[i] = overwrite_string.charAt(i-s);
        }
        // for(char c : chars){
        //     System.out.print(c);
        // }
        String answer = new String(chars);
        
        
        return answer;
    }
}