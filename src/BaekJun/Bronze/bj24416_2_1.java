package BaekJun.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [ 백준 24416번 알고리즘 수업 - 피보나치 수 1 ]
 * - 문제 설명
 *      1) 피보나치 수 구하는 알고리즘에 대한 이해를 확인하고자 한다.
 *      2) 피보나치 수를 재귀 호출과 동적 프로그래밍 두 가지 방식으로 구하는 알고리즘을 사용하여,
 *      3) 두 방식의 실행 횟수를 비교해보고자 한다.
 *      4) 피보나치 수 재귀호출 의사 코드
 *          fib(n) {
 *              if (n = 1 or n = 2)
 *              then return 1;  # 코드1
 *              else return (fib(n - 1) + fib(n - 2));
 *          }
 *      5) 피보나치 수 동적 프로그래밍 의사 코드
 *          fibonacci(n) {
 *              f[1] <- f[2] <- 1;
 *              for i <- 3 to n
 *                  f[i] <- f[i - 1] + f[i - 2];  # 코드2
 *              return f[n];
 *          }
 * - 입력 : 첫째 줄에 피보나치 수를 구할 n이 주어진다. n(5 <= n <= 40)이 주어진다.
 * - 출력 : 코드1과 코드2의 실행 횟수를 한 줄에 출력한다.
 * - 문제 분석
 *      1) 재취 호출 방식
 *          : 재귀 호출로 피보나치 수를 구할 때, fib(n)을 호출하면 그 하위로 여러 번의
 *          fib(n-1), fib(n-2) 호출이 중첩되어 실행된다. 이때 코드1이 호출되는 횟수를 카운트하면 된다.
 *      2) 동적 프로그래밍 방식
 *          : 동적 프로그래밍으로 피보나치 수를 구할 때는 f[i] <- f[i-1] + f[i-2]의 형태로 반복문에서 값이 계산되며,
 *          이 과정에서 코드2가 반복문 안에서 실행되는 횟수를 카운트한다.
 *          (1) f[1]과 f[2]를 1로 설정하여 시작한다.
 *          (2) for 루프를 통해 i = 3부터 n까지 진행하며 f[i] = f[i - 1] + f[i - 2]를 계산한다.
 *          (3) 코드2 실행 횟수: dpCount++를 통해 for 루프 내에서 코드2의 실행 횟수를 카운트한다.
 *          (4) 결과 반환: f[n] 값을 반환합니다.
 *      3) 두 방식의 실행 횟수를 비교해, 동적 프로그래밍 방식의 효율성을 확인하는 것이 목표이다.
 * - 결과 : [ 16008KB / 500ms ]
 */
public class bj24416_2_1 {
    // 실행 횟수를 저장할 변수 선언 및 초기화
    private static int recursionCount = 0;
    private static int dynamicCount = 0;

    // 재귀 호출 방식으로 피보나치 수 구하기
    public static int fib(int n) {
        if (n == 1 || n == 2) {
            recursionCount++;
            return 1;
        }
        return (fib(n - 1) + fib(n - 2));
    }

    // 동적 프로그래밍 방식으로 피보나치 수 구하기
    public static void fibonacci(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dynamicCount++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());

            // 1. 재귀 호출 방식으로 피보나치 수 구하기
            fib(n);

            // 2. 동적 프로그래밍 방식으로 피보나치 수 구하기
            fibonacci(n);

            // 3. 결과 출력
            System.out.println(recursionCount + " " + dynamicCount);

    }
}
