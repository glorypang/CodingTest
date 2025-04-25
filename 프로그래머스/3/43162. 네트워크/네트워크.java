import java.util.*;
class Solution {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    int n,m;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        m = computers[0].length;
        
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        
        
        for(int i = 0; i < n ; i++){
            graph[i+1] = new ArrayList<>();
        }
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(computers[i][j] == 1 && i != j){
                    graph[i+1].add(j+1);
                    graph[j+1].add(i+1);
                }
            }
        }
        for(int i = 1 ; i<=n ; i++){
            if(!visited[i]){
                dfs(i);
                answer++;
            }
        }
        return answer;
    }
    public void dfs(int node){
        visited[node] = true;
        for(int next : graph[node]){
            if(!visited[next]){
                dfs(next);
            }
        }
    }
}