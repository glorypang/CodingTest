import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        
        // 큐에 [인덱스, 우선순위] 형태로 넣기
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{i, priorities[i]});
        }

        int order = 0; // 몇 번째로 출력됐는지 세는 변수

        while (!queue.isEmpty()) {
            int[] current = queue.poll(); // 맨 앞 꺼냄
            boolean hasHigher = false;

            // 큐에 더 높은 우선순위가 있는지 확인
            for (int[] q : queue) {
                if (q[1] > current[1]) {
                    hasHigher = true;
                    break;
                }
            }

            if (hasHigher) {
                queue.offer(current); // 중요도 높은 게 있으면 다시 뒤로
            } else {
                order++; // 출력됨!
                if (current[0] == location) { // 내가 찾는 위치
                    return order;
                }
            }
        }

        return 0; 
    }
}
