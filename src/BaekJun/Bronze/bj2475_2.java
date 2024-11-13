package BaekJun.Bronze;

import java.util.Scanner;

/**
 * [ 백준 2475번 검증수 ]
 * - 문제 설명
 *      1) 컴퓨터마다 6자리 고유번호를 부여한다.
 *      2) 이 고유번호의 앞 5자리는 00000부터 99999까지의 숫자이며, 6번째 자리는 검증수이다.
 *      3) 검증수 계산법
 *          (1) 고유번호의 앞 5자리 숫자 각각을 제곱한다.
 *          (2) 제곱한 값들을 모두 더한다.
 *          (3) 이 합을 10으로 나눈 나머지가 검증수이다.
*       4) 예시
 *          (1) 고유번호의 앞 5자리가 04256일 때
 *          (2) 각 자리의 숫자를 제곱 : 0, 16, 4, 25, 36
 *          (3) 합계 : 0 + 16 + 4 + 25 + 36 = 81
 *          (4) 합계 81을 10으로 나눈 나머지 : 1
 * - 입력 : 첫째 줄에 고유번호의 처음 5자리의 숫자들이 빈칸을 사이에 두고 하나씩 주어진다.
 * - 출력 : 첫째 줄에 검증수를 출력한다.
 * - 문제 분석
 *      1. 5자리의 숫자를 입력 받는다.
 *      2. 제곱한 값들을 모두 더한다.
 *      3. 더한 값을 '%' 나머지 연산을 활용해 검증수를 구해 출력한다.
 * - 결과 : [ 17616KB / 180ms ]
 */
public class bj2475_2 {
    public static void main(String[] args) {
        // 1. 5자리 숫자를 입력 받는다.
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int D = sc.nextInt();
        int E = sc.nextInt();

        sc.close();

        // 2. 제곱한 값들을 모두 더한다.
        int Sum = (A * A) + (B * B) + (C * C) + (D * D) + (E * E);

        // 3. 더한 값을 '%' 나머지 연산을 활용해 검증수를 구해 출력한다.
        int result = Sum % 10;
        System.out.println(result);
    }
}
