package BaekJun.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * [ 백준 1927번 최소 힙 ]
 * 문제 설명 : 최소 힙을 이용하여 배열에 자연수 x를 넣는다,
 *           배열에서 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.
 *           프로그램은 처음에 비어있는 배열에서 시작하게 된다.
 * 입력 : 첫 번째 줄 연산의 개수 N이 주어진다.
 *       다음 N개의 줄에는 정수 x가 주어진다.
 *       1) x가 자연수라면 배열에 x라는 값을 추가하는 연산
 *       2) x가 0이라면 배열에서 가장 작은 값을 출력하고 그 값을 배열에서 제거
 * 출력 : x = 0이 주어졌을 때 배열에서 가장 작은 값을 출력하고 제거한 후 그 값을 출력한다.
 *       배열이 비어있는 상태에서 0이 주어지면 0을 출력한다.
 * 결과 : [ 25664KB / 248ms ]
 */
public class bj1927_8_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> miniHeap = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (miniHeap.isEmpty()) {
                    sb.append("0\n"); // 배열이 비어있으면 0 출력
                } else {
                    sb.append(miniHeap.poll()).append("\n"); // 가장 작은 값 출력 후 제거
                }
            } else {
                miniHeap.add(x); // 배열에 x 값을 추가
            }
        }
        System.out.println(sb);
    }
}
