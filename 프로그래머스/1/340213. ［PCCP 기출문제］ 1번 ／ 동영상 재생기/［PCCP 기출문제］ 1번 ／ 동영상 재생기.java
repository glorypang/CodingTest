class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int poss = Integer.parseInt(pos.replaceAll(":", ""));
        int opS =  Integer.parseInt(op_start.replaceAll(":", ""));
        int opE =  Integer.parseInt(op_end.replaceAll(":", ""));
        int vidL = Integer.parseInt(video_len.replaceAll(":", ""));
        if(poss >= opS && poss <= opE){
            poss = opE;
        }
        //System.out.println(poss);
        for(String com : commands){
           
            if(com.equals("next")){
                poss += 10;
                if(poss%100 >= 60){
                    poss +=40;
                }
                
                if(poss >= vidL){
                    poss = vidL;
                }
            }
            else{
                poss -= 10;
                if(poss%100 >= 60 && poss%100 <= 99){
                    poss -=40;
                }
                
                if(poss <=0){
                    poss = 0;
                }
            }
             
            if(poss >= opS && poss <= opE){
                poss = opE;
            }
            //System.out.println(com + "," + poss);
            
        }
        System.out.println(poss);
        StringBuilder sb = new StringBuilder();
        String temp = poss/100 + "";
        if(temp.length() == 1){
            sb.append("0");
            sb.append(temp);
        }
        else{
            sb.append(temp);
        }
        sb.append(":");
        String temp2 = poss%100 + "";
        if(temp2.length() == 1){
            sb.append("0");
            sb.append(temp2);
        }
        else{
            sb.append(temp2);
        }
        return sb.toString();
    }
}