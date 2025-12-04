import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        ArrayList<Integer> list = new ArrayList<>();
        for(long i = left; i <= right ;i++){
            long mok = i/n;
            long na = i%n;
            // System.out.println(mok +", " + na);
            list.add((int)(Math.max(mok, na))+1);
        }
        int[] answer = new int[list.size()];
        int indx = 0;
        for(int a : list){
            answer[indx++] = a;
        }
        return answer;
    }
}