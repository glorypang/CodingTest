import java.lang.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        //System.out.println(Math.ceil(a/2.0));
        int count = 0;
        double ta = a;
        double tb = b;
        while(true){

            
            ta = Math.ceil(ta/2) ;
            tb = Math.ceil(tb/2) ;
            System.out.println("ta = " +ta + ", tb = " + tb);
            if(ta == tb){
                return answer;
            }
            count++;
            answer++;
        }
    }
}