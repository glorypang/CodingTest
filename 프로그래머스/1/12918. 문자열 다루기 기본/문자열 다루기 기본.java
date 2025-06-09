class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        return s.matches("[0-9]{4}|[0-9]{6}") || s.matches("[0-9]") ;

    }
}