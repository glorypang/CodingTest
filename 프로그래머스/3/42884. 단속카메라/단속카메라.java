import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> {
            if(o1[1] == o2[1])
                return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        
        int Camera = 0; // 카메라의 수
        int position = Integer.MIN_VALUE; // 처음 카메라의 위치는 MIN_VAlue
        
        for(int i =  0; i < routes.length; i++){
            int start = routes[i][0];
            int end = routes[i][1];
            
            if(position < start){ //차가 카메라에 걸리지 않았다면
                Camera++;
                position = end;
            }
        }
        return Camera;
    }
}