class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey != 0){
            int n = storey % 10; //n = 6
            storey /= 10; // 1
            
            int n2 = storey % 10;
            if(n < 5){ 
                answer += n;
                //System.out.println("1IN");
            }
            else if(n == 5){
                if(n2 >= 5){
                    answer += 5;
                    storey++; // 6
                }else{
                    answer += 5;
                }
            }
            else{
                answer += 10-n; // 8
                storey++; // 6
                //System.out.println("2IN");
                
            }
        }
        return answer;
    }
}