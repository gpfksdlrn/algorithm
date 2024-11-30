package BaekJun.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * [ 백준 14235번 크리스마스 선물 ]
 * 문제 설명 : 산타는 아이들에게 가장 가치가 큰 선물을 나눠준다.
 *           거점지를 방문해 선물을 충전하거나 아이들을 만나 선물을 줄 때마다 규칙에 따라 결과를 출력해야 한다.
 *           선물이 없으면 -1을 출력한다.
 * 입력 : 첫 줄에는 산타가 방문한 횟수 n
 *       다음 n개의 줄 - 거점지라면 충전할 선물 개수 a와 그 뒤에 나열된 a개의 선물 가치
 *                  - 아이를 만났다면 a = 0
 * 출력 : a = 0일 때, 아이에게 준 가장 큰 선물의 가치를 출력
*        만약 선물이 없다면 -1 출력
 * 결과 : [ 41296KB / 300ms ]
 */
public class bj14235_8_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 최대 힙 생성 (선물의 가치를 저장)
        PriorityQueue<Integer> giftQueue = new PriorityQueue<>(Collections.reverseOrder());

        // 첫 번째 줄 입력: 방문 횟수 n
        int n = Integer.parseInt(br.readLine());

        // n번의 작업 처리
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);

            if (a == 0) {
                // 아이를 만나 선물 나눠줌
                if (giftQueue.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(giftQueue.poll()).append("\n");
                }
            } else {
                // 선물 충전
                for (int j = 1; j <= a; j++) {
                    giftQueue.offer(Integer.parseInt(input[j]));
                }
            }
        }

        // 결과 출력
        System.out.print(sb);
    }
}
