import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        int time = 0;
        int totalWeight = 0;
        int idx = 0;

        // 초기화: 다리를 0으로 채워서 시작
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }

        while (idx < truck_weights.length) {
            time++;
            totalWeight -= bridge.poll(); // 맨 앞 트럭 내림

            if (totalWeight + truck_weights[idx] <= weight) {
                bridge.offer(truck_weights[idx]);
                totalWeight += truck_weights[idx];
                idx++;
            } else {
                bridge.offer(0); // 트럭 못 올라가면 빈 공간 유지
            }
        }

        return time + bridge_length; // 마지막 트럭이 완전히 빠져나가는 시간 추가
    }
}
