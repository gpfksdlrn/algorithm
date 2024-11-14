package BaekJun.Silver;

import java.io.*;

/**
 * [ 백준 10994번 별 찍기 - 19 ]
 * - 문제 설명 : 예제를 보고 규칙을 유추한 뒤에 별을 찍어 보세요.
 * - 입력 : 첫째 줄에 N (1 <= N <= 100)이 주어진다.
 * - 출력 : 첫째 줄부터 차례대로 별을 출력한다.
 * - 문제 분석
 *      1. 출력 패턴 규칙
 *       - n값에 따라 (4n - 3) * (4n - 3)의 정사각형 별 패턴이 출력된다.
 *       - 각 패턴은 테두리가 별(*)로 둘러싸인 정사각형 모양이 반복되는 형태이며, 테두리 안에 들어갈수록 작은 정사각형으로 패턴이 중첩된다.
 *      2. 패턴 그리기 방식
 *       - 가장 바깥쪽의 테두리를 그린 뒤, 내부에 작은 정사각형 테두리를 계속 추가하는 재귀 방식을 이용한다.
 *       - 각 재귀 호출에서는 현재 패턴 크기를 4씩 줄이고, 시작 지점(offset)을 2씩 증가시켜 안쪽으로 이동하면서 작은 정사각형을 그린다.
 *      3. 메모리와 시간 최적화
 *       - BufferedWriter를 사용해 한 줄씩 버퍼에 저장한 후 한꺼번에 출력하여 속도를 개선한다.
 * - 결과 : [ 15856KB / 136ms ]
 */
public class bj10994_2_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int size = 4 * n - 3;
        char[][] pattern = new char[size][size]; // 2차원 배열 선언

        // 배열을 공백으로 초기화
        for (int i = 0; i < size; i++ ) {
            for (int j = 0; j < size; j++) {
                pattern[i][j] = ' ';
            }
        }

        // 패턴을 그리는 함수
        drawPattern(pattern, size, 0);

        // 결과 출력 함수
        for (char[] row : pattern) {
            for (char start : row) {
                bw.write(start);
            }
            bw.write('\n');
        }
        bw.flush(); // 버퍼 안에 저장되어 있는 모든 문자열을 출력 후 스트림을 비운다.
        bw.close(); // 스트림 종료
    }

    public static void drawPattern(char[][] pattern, int size, int offset) {
        if (size < 1) return; // 더 이상 그릴 패턴이 없을 떄 종료

        for (int i = 0; i < size; i++) {
            pattern[offset][offset + i] = '*'; // 위쪽
            pattern[offset + size -1][offset + i] = '*'; // 아래쪽
            pattern[offset + i][offset] = '*'; // 왼쪽
            pattern[offset + i][offset + size - 1] = '*'; // 오른쪽
        }

        // 내부에 작은 사각형 그리기 위해 재귀 호출
        drawPattern(pattern, size - 4, offset + 2);
    }
}