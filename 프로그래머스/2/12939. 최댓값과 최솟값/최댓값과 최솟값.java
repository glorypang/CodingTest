class Solution {
    public String solution(String s) {
        String[] strs = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(String str : strs){
            int temp = Integer.parseInt(str);
            if(max < temp)
                max = temp;
            
            if(min > temp)
                min = temp;
        }
        return min + " " + max;
    }
}