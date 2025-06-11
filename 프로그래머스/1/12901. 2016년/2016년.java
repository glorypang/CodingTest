class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int[] month = new int[]{0,31,29,31,30,31,30,31,31,30,31,30,31};
        
        String[] days = {"FRI", "SAT", "SUN", "MON", "TUE", "WED","THU"};
        
        int day = 0;
        for(int i = 0 ; i < a; i++){
            day += month[i];
        }
        day +=b;
        System.out.println(days[( month[1-1] + 7-1)%7]);
        
        return days[(day-1)%7];
    }
}