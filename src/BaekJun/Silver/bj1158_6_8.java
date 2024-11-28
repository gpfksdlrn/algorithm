package BaekJun.Silver;

import java.util.*;

/** [ 백준 1158번 요세푸스 문제 ]
 * 문제 설명 : 1번부터 N번까지 N명이 원을 이루어 앉아 있고, 양의 정수 K(≤ N)가 주어진다.
 *           K번째 사람을 순서대로 제거하며, 이를 반복해 모두 제거될 때까지 진행한다.
 *           제거된 순서를 (N, K)-요세푸스 순열이라고 한다.
 *           예를 들어, (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.
 * 입력 : 첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 <= K <= N <= 5,000)
 * 출력 : 예제와 같이 요세푸스 순열을 출력한다.
 * 문제 분석 : 1. 숫자 입력값을 N과 K로 받는다
 *           2. 1 ~ N값을 받기 위해 for문을 돌려 원형큐에 넣는다.
 *           3. K번째 수를 하나씩 도출해본다.
 * 결과 : [ 297872KB / 656ms ]
 */
public class bj1158_6_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 사람 수
        int K = sc.nextInt(); // K번째 사람 제거

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.offer(i); // 1부터 N까지 큐에 삽입
        }

        StringJoiner result = new StringJoiner(", ", "<", ">");

        // 큐를 사용하여 K번째 사람 제거
        while (!queue.isEmpty()) {
            for (int i = 1; i < K; i++) {
                queue.offer(queue.poll());
            }
            result.add(Objects.requireNonNull(queue.poll()).toString());
        }

        System.out.println(result);
        sc.close();
    }
}