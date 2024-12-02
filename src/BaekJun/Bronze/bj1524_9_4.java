package BaekJun.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * [ 백준 1524번 세준세비 ]
 * 문제 설명 : 세준이는 N명의 병사를, 세비는 M명의 병사를 키웠다.
 *           여러 번의 전투를 하며, 살아있는 병사 중 제일 약한 병사가 죽는다.
 *         규칙1. 만약 제일 약한 병사가 한 명만 있으면 그 병사가 죽습니다.
 *               제일 약한 병사가 여러 명일 경우:
 * 	                - 같은 편에 있다면 그 중 하나가 죽습니다.
 * 	                - 양 편에 각각 있다면 세비의 제일 약한 병사 중 한 명이 죽습니다.
 * 	       규칙2. 전쟁은 한 명의 병사만 남을 때까지 계속되며, 전쟁의 승자는 마지막 병사가 살아남은 사람입니다.
 * 	       규칙3. 승자
 * 	              - 세준이가 이기면 "S"
 * 	              - 세비가 이기면 "B"
 * 	              - 둘 다 아니면 "C"
 * 입력 : 첫째 줄에 테스트 케이스의 개수 T가 주어진다.
 *       각 테스트 케이스마다 N, M이 주어진다.
 *       그 후 세준이의 병사들의 힘 리스트와 세비의 병사들의 힘 리스트가 주어진다.
 * 출력 : 각 테스트 케이스마다 세준이가 이기면 "S", 세비가 이기면 "B", 둘 다 아니면 "C" 출력
 * 문제 풀이 2 : 어차피 병사가 가장 강하면 이기기 때문에 각 팀의 가장 큰 병사를 비교했을 때 큰 값이 이기는 것!!
 * 결과 : [ 85480KB / 584ms ]
 */
public class bj1524_9_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 개수 T
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            br.readLine(); // 빈 줄 무시
            // N(세준이 병사 수), M(세비 병사 수)
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            PriorityQueue<Integer> sejun = soldiersInput(br, N);
            PriorityQueue<Integer> sebi = soldiersInput(br, M);

            // 전투 시작
            while (!sejun.isEmpty() && !sebi.isEmpty()) {
                if (sejun.peek() > sebi.peek()) {
                    sb.append("S").append("\n");
                } else {
                    sb.append("B").append("\n");
                }
            }

            // 결과 출력
            if (!sejun.isEmpty())
                sb.append("S").append("\n");
            else if (!sebi.isEmpty())
                sb.append("B").append("\n");
        }
        System.out.println(sb);
    }

    private static PriorityQueue<Integer> soldiersInput(BufferedReader br, int count) throws IOException {
        PriorityQueue<Integer> soldiers = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 병사들의 힘 리스트
        for (int j = 0; j < count; j++) {
            soldiers.offer(Integer.parseInt(st.nextToken()));
        }
        return soldiers;
    }
}