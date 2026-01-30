class Solution {
    int len;
    boolean[] visit;
    String[] wordss;
    int answer  = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        len = words.length;
        visit = new boolean[len];
        wordss = words;
        
        dfs(begin, target, 0);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    void dfs(String word, String tar, int depth){
        if(word.equals(tar)){
            answer = Math.min(answer, depth);
            return;
        }
        
        for(int i = 0 ; i < len ; i++){
            if(!visit[i]){
                int cnt = 0;
                for(int j = 0; j < word.length(); j++){
                    if(word.charAt(j) != wordss[i].charAt(j)) cnt++;
                }
                if(cnt == 1){
                    visit[i] = true;
                    //System.out.println(word + " " + wordss[i] + " " + depth);
                    dfs(wordss[i], tar, depth+1);
                    visit[i] = false;
                }
            }
        }
    }
}