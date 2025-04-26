class Solution {
    public String solution(String my_string, int[] index_list) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(int c : index_list){
            sb.append(my_string.charAt(c));
        }
        return sb.toString();
    }
}