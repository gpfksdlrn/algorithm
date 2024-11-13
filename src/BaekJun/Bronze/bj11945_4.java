package BaekJun.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [ 백준 11945번 뜨거운 붕어빵 ]
 * - 문제 설명
 *      1) N개의 행과 M개의 열로 이루어진 배열이 주어지며, 각 칸은 0 또는 1로 채워져 있습니다.
 *      2) 0은 공백을 의미하고, 1은 붕어빵을 의미한다.
 *      3) 이 배열을 좌우 반전하여 출력하는 것이 목표이다.
 * - 입력
 *      1) 첫째 줄에는 두 개의 정수 N과 M이 주어진다.
 *          (1) N : 행의 개수 (1 <= N <= 10)
 *          (2) M : 열의 개수 (1 <= M <= 10)
 *      2) 그다음 N개의 줄에 걸쳐 각 줄에 M개의 0과 1로 이루어진 배열이 주어진다.
 * - 출력 : 입력으로 이루어진 배열을 좌우 반전한 형태로 출력한다.
 * - 문제 분석
 *      1. N과 M을 입력받고, N개의 줄에 걸쳐 M개의 숫자로 이루어진 문자열을 리스트에 저장한다.
 *      2. 각 줄의 문자열을 뒤집어 좌우 반전 처리
 *      3. 반전된 각 줄을 출력
 * - 결과 : [ 14032KB / 100ms ]
 */
public class bj11945_4 {
    public static void main(String[] args) throws IOException {
        // 1. 입력을 받기 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 2. 첫 줄을 읽어와 N과 M 값을 가져오기
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 3. N개의 문자열을 저장할 배열 선언
        String[] stringArr = new String[N];

        // 4. N개의 줄을 읽어와 배열에 저장
        for (int i = 0; i < N; i++) {
            stringArr[i] = br.readLine();
        }

        // 5. 배열의 각 문자열을 뒤집어 출력
        for (String s : stringArr) {
            StringBuilder builder = new StringBuilder(s).reverse();
            System.out.println(builder);
        }
    }
}