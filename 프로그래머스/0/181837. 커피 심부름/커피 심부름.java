class Solution {
    public int solution(String[] order) {
        int ansewr = 0;
        for(String str : order){
            if(str.equals("anything")){
                ansewr += 4500;
            }
            else if(str.contains("americano")){
                ansewr += 4500;
            }
            else{
                 ansewr += 5000;
            }
        }
        return ansewr;
    }
}