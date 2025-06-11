class Solution {
    int N;
    public String[] solution(int n, int[] arr1, int[] arr2) {
        N = n;
        String[] answer = new String[n];

        for(int i = 0 ; i < arr1.length; i++){
            String temp = to2(arr1[i], arr2[i]);
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j <temp.length(); j++){
                if(temp.charAt(j) == '1') sb.append("#");
                else sb.append(" ");
            }
            answer[i] = sb.toString();
        }
        
        System.out.println(to2(18, 17));
        
        
        return answer;
        
        
    }
    
    public String to2(int n, int m){
        StringBuilder sb = new StringBuilder();
        
        int num1 = n >= m ? n : m;
        int num2 = n+m - num1;
        
        while(num1 != 0 ){
            int temp1 = num1%2;
            int temp2 = num2%2;
            
            if(temp1 == 1 || temp2 == 1){
                sb.append("1");
            }
            else{
                sb.append("0");
            }
            num1 /= 2;
            num2 /= 2;
        }
        while(sb.length() <N){
            sb.append("0");
        }
        return sb.reverse().toString();
    }
}