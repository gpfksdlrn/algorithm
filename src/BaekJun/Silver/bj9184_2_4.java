package BaekJun.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [ 백준 9184번 신나는 함수 실행 ]
 * 함수 w에서 a, b, c 중 20이 넘어가게 되면 w(20, 20, 20)을 호출하고,
 * 0 이하일 경우에는 1을 반환하기 때문에
 * 각 배열의 크기가 21 (0 ~ 20)을 넘기지 않는다.
 * 결과 : [ 92996KB / 1316ms ]
 */
public class bj9184_2_4 {

    private final static int MAX_IDX = 21;
    static int[][][] dp = new int[MAX_IDX][MAX_IDX][MAX_IDX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // -1, -1, -1 이 나오면 종료
            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            sb.append(String.format("w(%d, %d, %d) = %d\n", a, b, c, w(a, b, c)));
        }
        System.out.println(sb);
    }

    public static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }

        if (dp[a][b][c] == 0) { // 캐시된 값이 없을 때만 계산
            if (a < b && b < c) {
                dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
            } else {
                dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
            }
        }

        return dp[a][b][c];
    }
}