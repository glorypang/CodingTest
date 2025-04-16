class Solution {
    public int solution(int hp) {
        int answer = 0;
        while(hp != 0){
            System.out.println("* ");

            if(hp/5 != 0){
                answer += hp/5;
                hp = hp - 5 * (hp/5);

            }
            else if(hp/3 != 0){
                answer += hp/3;
                hp = hp - 3 * (hp/3);
                
            }
            else if(hp/1 != 0){
                answer += hp/1;                
                hp = hp - (hp/1);
             }
        }
        return answer;
    }
}