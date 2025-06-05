import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dfs(0, "");
    }

    static void dfs(int index, String str) {
        if (isBad(str)) {
            return;
        }
        if (index == N) {
            System.out.println(str);
            System.exit(0);  // 조기 종료
        }

        dfs(index + 1, str + "1");
        dfs(index + 1, str + "2");
        dfs(index + 1, str + "3");
    }

    static boolean isBad(String str) {
        int len = str.length();
        int half = len / 2;

        for (int i = 1; i <= half; i++) {
            String first = str.substring(len - i * 2, len - i);
            String second = str.substring(len - i);
            if (first.equals(second)) {
                return true;
            }
        }
        return false;
    }
}