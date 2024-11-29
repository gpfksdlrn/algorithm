package BaekJun.Silver;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/** [ 백준 1417번 국회의원 선거 ]
 * 문제 설명 : 다솜이는 자신이 국회의원 선거에서 당선되기 위해, 다른 후보를 지지하는 사람들을 매수하려고 한다.
 *           다솜이(기호 1번)가 다른 모든 후보의 표보다 많은 표를 얻기 위해
 *           매수해야하는 최소 사람 수를 계산하는 프로그램을 작성하시오.
 * 입력 : 첫째 줄에 후보 수 N (1 <= N <= 50)
 *       둘째 줄에 다솜이를 지지하는 표 수
 *       이후 N - 1개의 줄에 각 후보를 지지하는 표 수
 * 출력 : 다솜이가 매수해야 하는 사람 수의 최솟값
 * 문제 분석 : 1. 후보의 수 N명, 다솜이의 초기 득표 수, 매수한 사람 수를 변수로 저장
 *           2. 우선순위 큐(PriorityQueue)를 사용하여, 나머지 후보들의 표를 저장
 *           3. 우선순위 큐를 내림차순으로 정렬해 가장 큰 값을 맨 앞으로 정렬한다.
 *           4. while 문은 peek 매서드를 통해 확인한 가장 큰 값이 다솜이의 표보다 크거나 같을 때까지 돌려준다.
 *           5. while 문 안에는
 *                  - 가장 큰 수를 꺼내 하나 빼주고,
 *                  - 다솜이의 표에 하나 더해주고,
 *                  - 매수한 횟수를 하나 늘려준다.
 *                  - 가장 큰 수를 꺼내 하나 뺀 수를 큐에 다시 넣어준다.
 *           6. while 문에서 나왔을 떄 매수한 횟수를 출력해준다.
 * 결과 : [ 13068KB / 96ms ]
 */
public class bj1417_7_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int dasomVotes = sc.nextInt(); // 다솜이의 초기 득표 수
        int bribes = 0; // 매수한 사람 수

        // 후보가 다솜이 한 명뿐이면 매수할 필요 없음
        if (N == 1){
            System.out.println(0);
            return;
        }

        // 우선순위 큐 PriorityQueue
        // 기본적으로 오름차순 정렬이며, 내림차순 정렬(Collections.reverseOrder())
        // 요소를 꺼낼 때 가장 우선순위가 높은 요소를 반환한다.
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // 다솜이를 제외한 표를 넣어준다.
        for (int i = 0; i < N - 1; i++) {
            pq.add(sc.nextInt());
        }

        // 다솜이의 득표 수가 모든 후보들의 표보다 많아질 때까지 반복
        while (!pq.isEmpty() && pq.peek() >= dasomVotes) {
            int maxVotes = pq.poll(); // 가장 많은 표
            maxVotes--; // 매수하여 표를 하나 감소시킴
            dasomVotes++; // 다솜이의 표를 하나 증가시킴
            pq.add(maxVotes); // 줄어든 표를 다시 큐에 넣음
            bribes++; // 매수 횟수 증가
        }
        sc.close();
        // 최소 매수 횟수 출력
        System.out.println(bribes);
    }
}
