package BaekJun.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [ 백준 2675번 문자열 반복 ]
 * - 문제 설명 : 문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오.
 * - 입력 : 첫째 줄에 테스트 케이스의 개수 T(1 <= T <= 1,000)가 주어진다.
 *         각 테스트 케이스는 반복 횟수 R(1 <= R <= 8), 문자열 S가 공백으로 구분되어 주어진다.
 *         S의 길이는 적어도 1이며, 20글자를 넘지 않는다.
 * - 출력 : 각 테스트 케이스에 대해 P를 출력한다.
 * - 결과 : [ 14044KB / 100ms ]
 */
public class bj2675_3_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int R = Integer.parseInt(st.nextToken()); // 반복 횟수
            String S = st.nextToken(); // 문자열 S

            for (char c : S.toCharArray()) {
                sb.append(String.valueOf(c).repeat(R)); // 각 문자를 R번 반복하여 결과에 추가
            }
            sb.append("\n"); // 각 테스트 케이스의 결과를 줄바꿈으로 구분
        }

        System.out.print(sb);
    }
}
