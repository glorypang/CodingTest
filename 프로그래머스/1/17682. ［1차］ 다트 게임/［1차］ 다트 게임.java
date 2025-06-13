class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int gap = 0;
        String num1 ="";
        int[] arr = new int[3];
        int idx = -1;
        for(char c : dartResult.toCharArray()){
            if(Character.isDigit(c)){
                num1 += c;
            }
            else if(Character.isLetter(c)){
                idx++;
                int num = Integer.parseInt(num1);
                if(c == 'S')
                    gap = (int)Math.pow(num, 1);
                else if(c == 'D')
                    gap  = (int)Math.pow(num, 2);
                else
                    gap  = (int)Math.pow(num, 3);
                arr[idx] = gap;
                num1 ="";
            }
            else{
                if(c == '*'){
                    if(idx> 0){
                        arr[idx-1] *= 2;
                        arr[idx] *= 2;
                    }
                    else{
                        arr[idx] *= 2;
                    }
                }
                else if(c == '#')
                    arr[idx] *= -1;
            }
            
        }
        for(int i = 0 ; i < 3; i++){
            answer += arr[i];
        }
        return answer;
    }
}