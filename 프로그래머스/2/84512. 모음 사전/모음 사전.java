
class Solution {
    char[] c = new char[]{'A', 'E', 'I', 'O', 'U'};
    int cnt = 0;
    int idx = 0;
    boolean check = false;
    StringBuilder sb = new StringBuilder();
    
    public int solution(String word) {
        int answer = 0;
        for(int i = 0 ; i < 5; i++){
            sb.append(c[i]);
            dfs(sb.toString(), word);
            sb.deleteCharAt(sb.length()-1);
        }
        return cnt;
    }
    void dfs(String str, String target){
        if(str.length() > 5) return;
        idx++;
        //stem.out.println(idx + ": " + str);
        
        if(target.equals(str)){
            cnt = idx;
            check = true;
            return;
        }
        for(int i = 0 ; i < 5; i++){
            if(!check){
                sb.append(c[i]);
                dfs(sb.toString(), target);
                sb.deleteCharAt(sb.length()-1);
            } 
        }
    }
}