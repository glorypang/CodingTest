class Solution {
    public String solution(String s) {
        int idx = 0;
        String answer ="";
        char c = ' ';
        for(int i = 0 ; i < s.length() ; i++){
            c = s.charAt(i);
            if(s.charAt(i) == ' '){
                idx = -1;
                System.out.println("Enter");                
            }
            if(idx%2 == 0){
                c = Character.toUpperCase(s.charAt(i));
                answer = answer + c;

            }
            else{
                c = Character.toLowerCase(s.charAt(i));
                answer = answer + c;
            }
            System.out.println(c + " " + idx);                
            
            idx ++;

                
            
        
        }
        return answer;
    }
}