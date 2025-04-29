class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for(int start = i ; start <= j ; start++){
            String s = Integer.toString(start);
            for(char c :s.toCharArray()){
                if(c-'0' == k)
                    answer++;
            }
        }
        return answer;
    }
}