class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder sb = new StringBuilder();        
        
        int lPx = 3;
        int lPy = 0;
        int rPx = 3;
        int rPy = 2;
        
        for(int n : numbers){
            if(n == 1 || n == 4 || n == 7){
                sb.append("L");
                lPx = (n-1)/3;
                lPy = (n-1)%3;
                System.out.println(n + ": " + "왼손1 : " + lPx + ", " + lPy);
            }
            else if( n== 3 || n == 6 || n == 9){
                sb.append("R");
                rPx = (n-1)/3;
                rPy = (n-1)%3;
                System.out.println(n + ": " + "오른손2 : " + rPx + ", " + rPy);
                
            }
            else{
                if(n == 0){
                    n = 11;
                }
                int tx = (n-1)/3;
                int ty = (n-1)%3;
                
                int lToN = Math.abs(tx-lPx) + Math.abs(ty-lPy);
                int RToN = Math.abs(tx-rPx) + Math.abs(ty-rPy);
                if(lToN < RToN ) {
                    sb.append("L");
                    lPx = (n-1)/3;
                    lPy = (n-1)%3;
                System.out.println(n + ": " + "왼손3 : " + lPx + ", " + lPy);
                    
                }
                else if(lToN > RToN ) {
                    sb.append("R");
                    rPx = (n-1)/3;
                    rPy = (n-1)%3;
                System.out.println(n + ": " + "오른손4 : " + rPx + ", " + rPy);
                    
                }
                else{
                    if(hand.equals("right")){
                        sb.append("R");
                        rPx = (n-1)/3;
                        rPy = (n-1)%3;
                System.out.println(n + ": " + "오른손5 : " + rPx + ", " + rPy);
                        
                    }
                    else{
                        sb.append("L");
                        lPx = (n-1)/3;
                        lPy = (n-1)%3;
                System.out.println(n + ": " + "왼손6 : " + lPx + ", " + lPy);
                        
                    }
                }
            }
        }
        return sb.toString();
    }
}