import java.util.*;

class Solution {
    int r; int c;
    int[][] map;
    public int solution(int n, int m, int[][] puddles) {
        int answer = 0;
        r = m; c = n;
        map = new int[r][c];
        
        for(int i = 0; i < r; i++){
            Arrays.fill(map[i],  1);
        }
        for(int[] p : puddles){
                map[p[1]-1][p[0]-1] = 0;
        }
        
        
        for(int i = 0 ; i < r; i++){
            for(int j = 0; j < c; j++){
                if(map[i][j] != 0){
                    if(i == 0 && j >= 1){
                        map[i][j] = map[i][j-1];
                    }
                    else if(j == 0 && i >=1){
                        map[i][j] = map[i-1][j];
                    }
                    else if(i !=0 && j !=0 )
                        map[i][j] = map[i-1][j]%1000000007 + map[i][j-1]%1000000007;  
                }
            }
        }
        
        // for(int i = 0 ; i < r; i++){
        //     for(int j = 0; j < c; j++){
        //         System.out.print(map[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        return map[r-1][c-1]%1000000007;
    }
}