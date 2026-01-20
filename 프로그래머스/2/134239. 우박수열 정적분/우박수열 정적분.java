import java.util.*;
class Solution {
    HashMap<Integer, Integer> list = new HashMap<>();    
    List<Double> li = new ArrayList<>();
    public double[] solution(int k, int[][] ranges) {
        List<Double> ans = new ArrayList<>();
        Collatz(k);
        
        for(int i = 0; i < list.size()-1; i++){
            li.add((double)(list.get(i)+list.get(i+1))/2);
        }
        
        for(int i = 0 ; i < ranges.length;i++){
            if(ranges[i][0] > li.size() - Math.abs(ranges[i][1])) {
                ans.add(-1.0);
                continue;
            }
            double s = 0;
            for(int j = ranges[i][0]; j < li.size() - Math.abs(ranges[i][1]); j++){
                s += li.get(j);
            }
            ans.add(s);
        }
        // for(double n : li){
        //     System.out.println(n);
        // }
        double[] answer = new double[ans.size()];
        int idx = 0;
        for(double n : ans){
            answer[idx++] = n;
        }
        
        return answer;
    }
   
    void Collatz(int k){
        int idx = 0;
        list.put(idx++, k);
        while( k != 1){
            if(k%2==0){
                k /= 2;
                list.put(idx++, k);
            }
            else{
                k *= 3;
                k++;
                list.put(idx++, k);
            }
        }
    }
}