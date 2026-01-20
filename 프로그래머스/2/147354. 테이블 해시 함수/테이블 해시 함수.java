import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data, (o1, o2) ->{
            if(o1[col-1] == o2[col-1])  return o2[0] - o1[0];
            return o1[col-1] - o2[col-1];
        });        
        int bit = 0;
        for(int i = row_begin-1 ;i < row_end; i++){
            int num = 0;
            for(int j = 0; j < data[i].length; j++){
                num += data[i][j]%(i+1);
            }
            if(i == row_begin-1) bit = num;
            else{
                bit = bit^num;
            }
            // System.out.println(bit);
            
            // System.out.println(data[i][0] + " " + data[i][1] +" " + data[i][2]);
        }
        return bit;
    }
}