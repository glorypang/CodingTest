class Solution {
    public int[] solution(String[] park, String[] routes) {
        int n = park.length;
        int m = park[0].length();
        int x = 0;
        int y = 0;
        for(int i = 0 ; i < n ; i++){
            if(park[i].contains("S")){
                x = i;
                y = park[i].indexOf("S");
                break;
            }
        }
    
        for(String rout : routes){
            String[] r = rout.split(" ");
            int move = Integer.parseInt(r[1]);
            boolean check = false;
            if(r[0].equals("E")){
                for(int i = 1 ; i <= move ; i++){
                    if(y+i >= m || park[x].charAt(y+i) == 'X'){
                        check = true;
                        break;
                    } 
                }
                if(!check){
                    y += move;
                }
            }
            
            else if(r[0].equals("W")){
                for(int i = 1 ; i <= move ; i++){
                    if(y-i < 0 || park[x].charAt(y-i) == 'X'){
                        check = true;
                        break;
                    } 
                }
                if(!check){
                    y -= move;
                }
            }
            else if(r[0].equals("N")){
                for(int i = 1 ; i <= move ; i++){
                    if( x-i < 0 ||park[x-i].charAt(y) =='X'){
                        check = true;
                        break;
                    } 
                }
                if(!check){
                    x -= move;
                }
            }
            else if(r[0].equals("S")){
                for(int i = 1 ; i <= move ; i++){
                    if( x+i >= n || park[x+i].charAt(y) == 'X'){
                        check = true;
                        break;
                    } 
                }
                if(!check){
                    x += move;
                }
            }
        }
        int[] pos = new int[]{x,y};
        
        return pos;
    }
}