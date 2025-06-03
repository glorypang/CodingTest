class Solution {
    public String solution(String my_string, int[][] queries) {
        String answer = "";
        for(int[] arr : queries){
            String s = my_string.substring(arr[0], arr[1]+1);
            StringBuilder sb = new StringBuilder(s);
            sb.reverse();
            StringBuilder sb2 = new StringBuilder();
            
            boolean check = false;
            for(int i = 0 ; i<  my_string.length(); i++){
                if(i >= arr[0] && i <= arr[1] && !check){
                    check = true;
                    sb2.append(sb.toString());
                }
                else if( i < arr[0] || i > arr[1])
                    sb2.append(my_string.charAt(i));
            }
            my_string = sb2.toString();
        }
        answer = my_string;
        
        return answer;
    }
}