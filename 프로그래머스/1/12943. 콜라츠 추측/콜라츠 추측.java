class Solution {
    public int solution(int num) {
        int answer = 0;
        long n = num;
        while(n != 1 && answer < 500){
            if(n%2 == 0)
                n = n/2;
            else 
                n = n*3 +1;
            answer++;
            System.out.println(n);

        }
        System.out.println(n);
        return n == 1 ? answer : -1;
    }
}