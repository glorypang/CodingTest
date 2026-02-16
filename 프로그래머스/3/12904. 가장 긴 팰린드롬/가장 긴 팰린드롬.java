class Solution
{
    int len = 0;
    String ss;
    int answer = 1;
    public int solution(String s)
    {
        ss =s;
        len = s.length();
        if(len == 1) return 1;
        
        for (int i = 0; i < len; i++) {
            if (i + 1 < len && s.charAt(i) == s.charAt(i+1)) func(i, i+1); // aa
            if (i + 2 < len && s.charAt(i) == s.charAt(i+2)) func(i, i+2); // aba
        }

        return answer;
    }
    
    void func(int l, int r){
        int left = l;
        int right = r;
        int cnt = 0;
        if(r-l == 2) cnt =1;
        while(left >= 0 && right < len){
            if(ss.charAt(left) == ss.charAt(right)){
                cnt+=2;
            }
            else
                break;
            left--;
            right++;
        }
        answer = Math.max(answer, cnt);
    }
}