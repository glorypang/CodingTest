class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int idx = 0;
        for(String s : targets){
            int sum = 0;
            
            for(int i = 0 ; i< s.length(); i++){
                int type = Integer.MAX_VALUE;
                
                for(String key : keymap){
                    if(key.contains(s.charAt(i)+"")){
                        type = Math.min(type, key.indexOf(s.charAt(i))+1);
                    }
                    
                }
                //System.out.println(type);
                
                if (type == Integer.MAX_VALUE) {
                    sum = -1;
                    break;
                }
                
                sum +=type;
            }
            
            answer[idx++] = sum;
            //System.out.println(sum);
            
        }
        return answer;
    }
}