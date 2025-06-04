class Solution {
    public int solution(int chicken) {
        int answer = 0;
        int na = 0;
        int coupon = 0;
        while(chicken != 0){
            chicken += coupon;
            answer += chicken/10; 
            coupon = chicken%10; 
            chicken /= 10;  
            
        }
    
        return answer;
    }
}