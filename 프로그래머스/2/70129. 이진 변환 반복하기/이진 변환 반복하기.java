class Solution {
    public int[] solution(String s) {
        int[] answer = {};

        int sum = 0;        
        int cnt = 0;

        int after = 0;
        while(after != 1){
            int before = s.length();
            after = s.replaceAll("0", "").length();

            sum += before-after;
            s = to2(after);
            cnt++;

        }
   

        return new int[]{cnt, sum};
    }
    
    public String to2 (int num){
        
        StringBuilder sb = new StringBuilder();
        while(num != 0){
            sb.append(num%2);
            num /= 2;
        }
        
        return sb.reverse().toString();
    }
}