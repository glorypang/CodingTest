import java.util.Scanner;

public class Main {
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        int[] queens = new int[n];
        backtrack(n, 0, queens);
        System.out.println(count);
    }

    private static void backtrack(int n, int row, int[] queens) {
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(row, col, queens)) {
                queens[row] = col;
                backtrack(n, row + 1, queens);
            }
        }
    }

    // 퀸 배치가 가능한지 체크 (같은 열, 같은 대각선 확인)
    private static boolean isValid(int row, int col, int[] queens) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col) return false; // 열 충돌
            if (Math.abs(row - i) == Math.abs(col - queens[i])) return false; // 대각선 충돌
        }
        return true;
    }
}
