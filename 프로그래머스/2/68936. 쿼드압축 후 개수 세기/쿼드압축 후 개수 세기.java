class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        int r = arr.length;
        int c = arr[0].length;
        boolean[][] map = new boolean[r][c];
        
        int c1 = 0;
        int c0 = 0;
        for(int i = 0 ; i <r ;i++){
            for(int j = 0 ; j < c; j++){
                if(arr[i][j] == 1){
                    c1++;      
                }
                else{
                    c0++;
                }
            }
        }
        System.out.println(c0 +" , " + c1);
        
        for(int i = r ; i > 0 ; i/=2){
            for(int j = 0; j < r ; j +=i){
                for(int z = 0 ; z < c ; z +=i){
                    int std = arr[j][z]; 
                    boolean check = true;
                    if(!map[j][z]){
                        for(int a = 0; a < i ; a++){
                            if(check){
                               for(int b = 0 ; b < i; b++){
                                    if(arr[j+a][z+b] != std) {
                                        check = false;                                    
                                        break;
                                    }
                                } 
                            }
                        }
                        if(check){
                            for(int a = 0; a < i ; a++){
                                for(int b = 0 ; b < i; b++){
                                    arr[j+a][z+b] = std;
                                    map[j+a][z+b] = true;
                                }
                            }
                            
                            if(std == 1) {
                                //System.out.println("1");
                                c1 -= Math.pow(i, 2)-1;
                            }
                            else{
                                c0 -= Math.pow(i, 2)-1;
                            }
                        }
                    }
                }
            }
        }
        // System.out.println(c0 +" , " + c1);
        // for(int i = 0 ; i <r ;i++){
        //     for(int j = 0 ; j < c; j++){
        //         System.out.print(arr[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        return new int[]{c0,c1};
    }
}