import java.util.*;

class Solution {
    public int solution(int[] a) {
        int n = a.length;
        if (n <= 2) return n; // 1개, 2개는 항상 가능

        int[] leftMin = new int[n];
        int[] rightMin = new int[n];

        // leftMin[i] = 0 ~ i 구간의 최소값
        leftMin[0] = a[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], a[i]);
        }

        // rightMin[i] = i ~ n-1 구간의 최소값
        rightMin[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], a[i]);
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n - 1) {
                answer++;
                continue;
            }

            boolean hasSmallerLeft = leftMin[i - 1] < a[i];
            boolean hasSmallerRight = rightMin[i + 1] < a[i];

            // 양쪽에 더 작은 값이 모두 있으면 불가능
            if (!(hasSmallerLeft && hasSmallerRight)) {
                answer++;
            }
        }

        return answer;
    }
}