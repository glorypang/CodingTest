class Solution {
    public String solution(String bin1, String bin2) {
        int n = to10(bin1) + to10(bin2);
        String answer = to2(n);
        // String answer =" ";
        // System.out.println(to2(0));
        return answer;
    }
    public int to10(String s){
        int sum  = 0;
        int len = s.length()-1;
        for(char c : s.toCharArray()){
            sum += (c-'0') * Math.pow(2, len--);
        }
        return sum;
    }
    public String to2(int n){
        StringBuilder sb = new StringBuilder();
        if(n == 0) return "0";
        while(n != 1){
            sb.append(n%2);
            n /=2;
        }
        sb.append(1);
            
        return sb.reverse().toString();
    }
}