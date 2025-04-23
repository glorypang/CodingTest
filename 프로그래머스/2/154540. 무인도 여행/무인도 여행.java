import java.util.*;
class Solution {
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    boolean[][] visited;
    int n, m;
    char[][] map;
    
    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        visited = new boolean[n][m];
        map = new char[n][m];
        
        for(int i = 0 ; i< n ;i++){
            map[i] = maps[i].toCharArray();
        }
    
        List<Integer> dayList = new ArrayList<>();
        
        for(int i = 0; i <n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(!visited[i][j] && map[i][j] != 'X'){
                    int sum = dfs(i,j);
                    dayList.add(sum);
                }
            }
        }
        
        if(dayList.isEmpty()){
            return new int[]{-1};
        }
        int[] answer = new int[dayList.size()];
        for(int i = 0 ; i< dayList.size(); i++){
            answer[i] = dayList.get(i);
        }
        Arrays.sort(answer);
        
        return answer;
    }
    
    public int dfs(int x, int y){
        visited[x][y] = true;
        int sum = map[x][y] - '0';
        
        for(int dir = 0 ; dir < 4 ;dir++){
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if(nx >= 0 && nx < n && ny >= 0 && ny < m){
                if(!visited[nx][ny] && map[nx][ny] != 'X'){
                    sum += dfs(nx,ny);
                }
            }
        }
        return sum;
    }
}