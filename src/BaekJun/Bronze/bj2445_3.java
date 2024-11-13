package BaekJun.Bronze;

import java.util.Scanner;

/**
 * [ 백준 2445번 별찍기 - 8 ]
 * - 문제 설명 : 숫자 N이 주어졌을 때, N개의 줄에 걸쳐 차례대로 별(*)을 출력한 뒤, 반대로 별을 줄여 나가면서 2N - 1줄까지 별을 출력하는 프로그램을 작성하세요.
 * - 입력 : 첫째 줄에 N(1 <= N <= 100)이 주어진다.
 * - 출력 : 첫째 줄부터 2N - 1번째 줄까지 차례대로 별을 출력한다.
 * - 문제 분석
 *      1. 숫자 N을 입력 받는다.
 *      2. 상단에서는 별의 개수를 늘려가며 출력한다.
 *      3. 하단에서는 별의 개수를 줄여가며 출력한다.
 * - 결과 : [ 23328KB / 472ms ]
 */
public class bj2445_3 {
    public static void main(String[] args) {
        // 1. 숫자 N을 입력 받는다.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        // 2. 상단에서는 별의 개수를 늘려가며 출력한다.
        for (int i = 1; i <= N; i++) {
            // 왼쪽 삼각형
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            // 가운데 삼각형
            for (int j = 1; j <= (N-i) * 2; j++) {
                System.out.print(" ");
            }

            // 오른쪽 삼각형
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 3. 하단에서는 별의 개수를 줄여가며 출력한다.
        for (int i = 1; i < N; i++) {
            // 왼쪽 삼각형
            for (int j = 1; j <= N - i; j++) {
                System.out.print("*");
            }

            // 가운데 삼각형
            for (int j = 1; j <= i * 2; j++) {
                System.out.print(" ");
            }

            // 오른쪽 삼각형
            for (int j = 1; j <= N - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}