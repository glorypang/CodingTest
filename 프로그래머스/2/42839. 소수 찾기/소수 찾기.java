import java.util.*;
class Solution {
    char[] chs;
    List<Integer> list = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    boolean[] visit;
    public int solution(String numbers) {
        int answer = 0;
        chs = numbers.toCharArray();
        visit = new boolean[numbers.length()];
        dfs(0);
        
        // for(int n : list){
        //     System.out.println(n);
        // }
        return list.size();
    }
    void dfs(int idx){
        if(sb.length() > 0){
            int num = Integer.parseInt(sb.toString());
            if(isPrime(num)){
                if(!list.contains(num)){
                    list.add(num);
                }
            }
        }
        
        for(int i = 0; i < chs.length; i++){
            if(!visit[i]){
                sb.append(chs[i]);
                visit[i] = true;
                dfs(i);
                sb.deleteCharAt(sb.length()-1);
                visit[i] = false;
            }
        }
    }
    boolean isPrime(int n){
        if(n == 0 || n == 1) return false;
        
        for(int i = 2 ; i<= Math.sqrt(n); i++){
            if(n%i == 0) return false;
        }
        
        return true;
    }
}