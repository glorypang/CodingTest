class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String temp = a+""+b;
        int temp1 = Integer.parseInt(temp);
        int temp2 = a*b*2;
        return temp1 >= temp2 ? temp1 : temp2;
    }
}