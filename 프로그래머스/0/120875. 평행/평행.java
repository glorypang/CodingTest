import java.math.*;
import java.util.Arrays;

class Solution {
    public int solution(int[][] dots) {
        int answer = 0;

        if (Arrays.equals(incline(dots[0][0], dots[0][1], dots[1][0], dots[1][1]),
                          incline(dots[2][0], dots[2][1], dots[3][0], dots[3][1]))) {
            return 1;
        }
        if (Arrays.equals(incline(dots[0][0], dots[0][1], dots[2][0], dots[2][1]),
                          incline(dots[1][0], dots[1][1], dots[3][0], dots[3][1]))) {
            return 1;
        }
        if (Arrays.equals(incline(dots[0][0], dots[0][1], dots[3][0], dots[3][1]),
                          incline(dots[1][0], dots[1][1], dots[2][0], dots[2][1]))) {
            return 1;
        }

        return answer;
    }

    public int[] incline(int x1, int y1, int x2, int y2) {
        int par = y2 - y1;
        int chi = x2 - x1;
        if (chi == 0) return new int[]{1, 0}; // 세로선
        if (par == 0) return new int[]{0, 1}; // 가로선

        int g = gcd(Math.abs(par), Math.abs(chi));
        par /= g;
        chi /= g;

        // 분모(chi)를 양수로 정규화
        if (chi < 0) {
            par = -par;
            chi = -chi;
        }

        return new int[]{par, chi};
    }


    public int gcd(int x, int y) {
        BigInteger a = BigInteger.valueOf(x);
        BigInteger b = BigInteger.valueOf(y);
        BigInteger gcd = a.gcd(b);
        return gcd.intValue();
    }
}
