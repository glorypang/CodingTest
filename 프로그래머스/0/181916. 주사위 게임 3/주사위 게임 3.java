import java.util.*;
class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(a, map.getOrDefault(a, 0)+1);
        map.put(b, map.getOrDefault(b, 0)+1);
        map.put(c, map.getOrDefault(c, 0)+1);
        map.put(d, map.getOrDefault(d, 0)+1);
        
        if(map.size() == 1){
            return a * 1111;
        }
        else if(map.size() == 2){
            int idx = 0;
            int[] nums = new int[2];
            for(int key : map.keySet()){
                nums[idx++] = key;
            }
            if(map.get(nums[0]) == map.get(nums[1])){
                return (nums[0] + nums[1]) * Math.abs(nums[0] - nums[1]);
            }
            else{
                if(map.get(nums[0]) == 3)
                     return (int)Math.pow(10*nums[0] + nums[1], 2);
                else
                    return (int)Math.pow(10*nums[1] + nums[0], 2);
                                        
            }
        }
        else if(map.size() == 3){
            int idx = 0;
            int[] nums = new int[3];
            for(int key : map.keySet()){
                nums[idx++] = key;
            }
            if(map.get(nums[0]) == 2)
                return nums[1]*nums[2];
            else if(map.get(nums[1]) == 2)
                return nums[0]*nums[2];
            else
                return nums[1]*nums[0];
                                        
        }
        else{
             int idx = 0;
            int[] nums = new int[4];
            for(int key : map.keySet()){
                nums[idx++] = key;
            }
            Arrays.sort(nums);
            return nums[0];
        }
    }    
}