import java.math.*;
class Solution
{
    public int solution(int n, int a, int b)
    {
        int cnt = (int)(Math.log(n)/Math.log(2));
        System.out.println(cnt);
       
        if(a > b){
            int temp = a;
            a = b;
            b = temp;
        }
            
        double calc = Math.pow(2, cnt-1);

        for(int i = 0; i <cnt ; i++){
            // System.out.println(i + " " +calc);

            if(a <= calc && b >calc){
                return cnt-i;
            }
            else if(a<=calc){
                calc -= Math.pow(2, cnt-i-2);
            }
            else{
                calc += Math.pow(2, cnt-i-2);
            }
        }


        return 0;
    }
}