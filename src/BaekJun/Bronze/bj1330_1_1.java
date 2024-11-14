package BaekJun.Bronze;

import java.util.Scanner;

/**
 * [ 백준 1330번 두 수 비교하기 ]
 * - 문제 설명 : 두 정수 A와 B가 주어졌을 때, A와 B를 비교하는 프로그램을 작성하시오.
 * - 입력 : 첫째 줄에 A와 B가 주어진다. A와 B는 공백 한 칸으로 구분되어져 있다.
 * - 출력 : 첫째 줄에 다음 세 가지 중 하나를 출력한다.
 *      - A가 B보다 큰 경우에는 '>'를 출력한다.
 *      - A가 B보다 작은 경우에는 '<'를 출력한다.
 *      - A와 B가 같은 경우에는 '=='를 출력한다.
 * - 문제 분석
 *      1. 두 수를 입력 받는다.
 *      2. 두 수를 비교하여 알맞은 연산자를 출력한다.
 * - 결과 : [ 17672KB / 172ms ]
 */
public class bj1330_1_1 {
    public static void main(String[] args) {
        // 1. 두 수를 입력받는다.
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        sc.close();

        // 2. 입력 받은 두 수를 비교하여 알맞은 연산자를 출력한다.
        if (A > B) {
            System.out.println(">");
        } else if (A < B) {
            System.out.println("<");
        } else {
            System.out.println("==");
        }
    }
}
