class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String[] chars = my_string.split(" ");
        boolean c = true; //t 더하기, f 빼기
        
        for(int i=  0 ; i< chars.length; i++){
            int n;
            if(i%2 == 0){
                if(c){
                    answer += Integer.parseInt(chars[i]);
                }
                else{
                    answer -= Integer.parseInt(chars[i]);
                }
            }
            else{
                if(chars[i].equals("+")){
                    c = true;
                }
                else{
                    c = false;
                }
            }
        }
        return answer;
    }
}