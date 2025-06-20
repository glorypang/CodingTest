class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = schedules.length;
        for(int i = 0 ; i < schedules.length; i++){
            int limit = schedules[i]+10;
            if(limit%100 >= 60){
                limit+=40;
            }
            int day = startday;
            for(int j = 0 ; j< timelogs[i].length; j++){
                if((day-1)%7 <=4 && limit < timelogs[i][j]){
                    //System.out.println(day + ", " + i + ", " + j);
                    answer--;
                    break;
                }
                day++;
                
            }
        }
        return answer;
    }
}