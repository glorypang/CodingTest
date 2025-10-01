import java.io.*;
import java.util.*;

public class Main {
    static class Paper {
        int big, small; // big >= small
        Paper(int a, int b) {
            if (a >= b) { big = a; small = b; }
            else { big = b; small = a; }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        Paper[] arr = new Paper[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i] = new Paper(a, b); // 회전 고려하여 정규화
        }

        // 아래에서부터 위로 쌓는 순서를 만들기 위해
        // (big, small) 둘 다 "내림차순"으로 정렬
        Arrays.sort(arr, (p1, p2) -> {
            if (p1.big != p2.big) return p2.big - p1.big;          // big 내림차순
            return p2.small - p1.small;                            // small 내림차순
        });

        // dp[i] = i번째를 "위에" 올렸을 때 만들 수 있는 최대 장수 (i 포함)
        int[] dp = new int[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1; // 자기 자신만 쌓은 경우
            for (int j = 0; j < i; j++) {
                // j가 아래, i가 그 위에 올 수 있는 조건:
                // j.big >= i.big && j.small >= i.small
                if (arr[j].big >= arr[i].big && arr[j].small >= arr[i].small) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }
}
