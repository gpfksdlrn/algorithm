package BaekJun.Silver;

import java.io.*;

/**
 * [ 백준 13116번 30번 ]
 * 입력 : 첫 번째 줄에 테스트 케이스의 수 T (1 <= T <= 50000)가 주어진다.
 *       각 테스트 케이스는 한 줄로 구성되어 있으며,
 *       두 개의 정수 A와 B(1 <= A, B <= 1023, A != B)가 공백을 사이로 두고 주어진다.
 * 문제 분석 : 해당 문제는 완전 이진 트리이기 때문에 배열 없이 계산 가능
 *           1부터 순차적으로 증가하기 때문에 정점의 숫자에 따라 깊이를 찾을 수 있다.
 *           두 개의 정점의 깊이를 맞춘
 * 결과 : [ 41408KB / 284ms ]
 */
public class bj13116_30번 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCase; i++) {
            String[] line = br.readLine().split(" ");
            short A = Short.parseShort(line[0]);
            short B = Short.parseShort(line[1]);

            // 공통 조상 찾기 (두 값이 같아질 때까지 반복)
            while (A != B) {
                if (A > B) A /= 2; // A가 더 크면 부모로 이동
                else B /= 2; // B가 더 크면 부모로 이동
            }
            // 결과 작성 (공통 조상 * 10)
            bw.write((A * 10) + "\n");
        }
        // 결과 출력
        bw.flush();
        bw.close();
        br.close();
    }
}