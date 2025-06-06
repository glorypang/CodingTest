class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        
        boolean[][] line = new boolean[lines.length][201];
        
        
        int idx = 0;
        for(int[] l :lines){
            for(int i = l[0]+101 ; i <= l[1]+100 ; i++){
                line[idx][i] = true;
            }
            
            for(int i = 100 ; i <= 110; i++){
                System.out.print(line[idx][i] + "     ");
            }
            System.out.println();
            idx++;
        }
        
        boolean check = false;
        for(int i = 0 ; i <=200 ; i++){
            if((line[0][i] && line[1][i] )|| (line[0][i] && line[2][i] ) || (line[2][i] && line[1][i])){
                answer++;
                check = true;
            }
        }
        if(answer > 0)
            return answer;
        
        else{
            return 0;
        }
    }
}