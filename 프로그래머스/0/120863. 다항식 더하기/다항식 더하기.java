class Solution {
    public String solution(String polynomial) {
        String answer = "";
        String[] arrs = polynomial.split(" ");
        int poly = 0;
        int num = 0;
        for(String arr : arrs){
            if(arr.contains("x")){
                if(arr.length() == 1){
                    poly += 1;
                }
                else{
                    poly += Integer.parseInt(arr.substring(0, arr.length()-1));
                }
            }
            else if(arr.equals("+")){
                continue;
            }
            else{
                num += Integer.parseInt(arr);
            }
        }
        if (poly == 0 && num == 0) {
            answer = "0";
        } else if (poly == 0) {
            answer = num + "";
        } else if (poly == 1 && num == 0) {
            answer = "x";
        } else if (poly == 1) {
            answer = "x + " + num;
        } else if (num == 0) {
            answer = poly + "x";
        } else {
            answer = poly + "x + " + num;
        }

        
        return answer;
    }
}