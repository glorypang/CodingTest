import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] num_list) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int n : num_list)
            arr.add(n);
        Collections.reverse(arr);
        return arr;
    }
}