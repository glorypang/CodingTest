class Solution {
    public int solution(int[] num_list) {
        String Even = "";
        String Odd = Even;
        for(int n : num_list){
            if(n%2 == 0)
                Even = Even + n;
            else
                Odd = Odd + n;
        }        
        int answer = Integer.parseInt(Even) + Integer.parseInt(Odd);
        return answer;
    }
}