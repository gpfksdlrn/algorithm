package BaekJun.Silver;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * [ 백준 1026번 보물 ]
 * 문제 설명 : 길이가 N인 정수 배열 A와 B가 있다. 다음과 같이 함수 S를 정의한다.
 *           S = A[0] * B[0] +...+ A[N-1] * B[N-1]
 *           S의 값을 가장 작게 만들기 위해 A의 수를 재배열하자.
 *           단, B에 있는 수는 재배열하면 안 된다.
 *           S의 최솟값을 출력하는 프로그램을 작성하시오.
 * 입력 : 첫째 줄에 N이 주어진다.
 *       둘째 줄에 A에 있는 N개의 수가 순서대로 주어지고,
 *       셋째 줄에는 B에 있는 수가 순서대로 주어진다.
 *       N은 50보다 작거나 같은 자연수이고, A와 B의 각 원소는 100보다 작거나 같은 음이 아닌 정수이다.
 * 출력 : 첫째 줄에 S의 최솟값을 출력한다.
 * 결과 : [ 13084KB / 100ms ]
 * [예제 입력]
 * 5
 * 1 1 1 6 0
 * 2 7 8 3 1
 * ----------
 * [예제 출력]
 * 18
 */

public class bj1026_11_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 배열 선언
        int[] A = new int[N];
        Integer[] B = new Integer[N];

        // A배열
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        // B배열
        for (int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
        }

        // 정렬
        Arrays.sort(A); // 오름차순
        Arrays.sort(B, Collections.reverseOrder()); // 내림차순

        int result = 0;
        for (int i = 0; i < N; i++) {
            result += A[i] * B[i];
        }

        System.out.println(result);
    }
}
