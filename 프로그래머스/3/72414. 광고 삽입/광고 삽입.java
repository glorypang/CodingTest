class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        
        int playTime = toSeconds(play_time);
        int advTime = toSeconds(adv_time);
        
        long[] times = new long[playTime + 2];  
        
        for (String log : logs) {
            String[] parts = log.split("-");
            int start = toSeconds(parts[0]);
            int end = toSeconds(parts[1]);
            times[start] += 1;
            times[end] -= 1;
        }
        
        // 누적 시청자 수 계산
        for (int i = 1; i <= playTime; i++) {
            times[i] += times[i - 1];
        }
        
        // 누적 시청 시간 계산
        for (int i = 1; i <= playTime; i++) {
            times[i] += times[i - 1];
        }
        
        long maxView = times[advTime - 1];
        int startTime = 0;
        
        for (int i = advTime; i <= playTime; i++) {
            long currentView = times[i] - times[i - advTime];
            if (currentView > maxView) {
                maxView = currentView;
                startTime = i - advTime + 1;
            }
        }
        
        return toTimeFormat(startTime);
    }
    
    private int toSeconds(String time) {
        String[] parts = time.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int s = Integer.parseInt(parts[2]);
        return h * 3600 + m * 60 + s;
    }
    
    private String toTimeFormat(int time) {
        int h = time / 3600;
        int m = (time / 60) % 60;
        int s = time % 60;
        
        return String.format("%02d:%02d:%02d", h, m, s);
    }
}