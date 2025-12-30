import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long total = 0;
        List<Integer> list = new ArrayList<>();
        
        long sum = 0;
        for(int n : queue1){
            total += n;
            list.add(n);
            sum += n;
        }
        for(int n : queue2){
            total += n;
            list.add(n);
        }
        
        long target = 0;
        if(total %2 == 1 ) return -1;
        else target = total/2;
        
        int left = 0;
        int right = queue1.length-1;
        
        // while(answer <= list.size() *2){
        //     if(sum < target){
        //         sum += list.get(++right);
        //         answer++;
        //     }
        //     else if(sum > target){
        //         sum -= list.get(left);
        //         right--;
        //         list.add(list.remove(0));
        //         answer++;
        //     }
        //     else{
        //         return answer;
        //     }
        //     // System.out.println("L : " + left + ", R : " + right);
        //     // for(int n : list){
        //     //     System.out.print(n + " ");
        //     // }
        //     // System.out.println();
        // }
        while(right != list.size()-1){
            if(sum < target){
                sum += list.get(++right);
                answer++;
            }
            else if(sum > target){
                sum -= list.get(left++);
                answer++;
            }
            else{
                return answer;
            }
        }
            
        return -1;
    }
}