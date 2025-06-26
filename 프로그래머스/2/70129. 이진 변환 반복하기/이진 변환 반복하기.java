class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        
        int idx = 0;
        int cnt = 0;
        while(!s.equals("1")){
            String temp = s.replaceAll("0", "");;
            cnt += s.length() - temp.length();
            s= to2(temp.length());
            idx++;
        }
        return new int[]{idx, cnt};
    }
    public String to2(int n){
        if(n==0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while(n != 0){
            sb.append(n%2);
            n /= 2;
        }
        return sb.reverse().toString();
    }
}