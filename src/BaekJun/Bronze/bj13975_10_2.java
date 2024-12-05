package BaekJun.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * [ 백준 13975번 파일 합치기 3 ]
 * 문제 설명 : 여러 개의 파일(소설의 장)을 하나의 파일로 합치려 한다.
 *           두 파일을 합칠 때 드는 비용은 두 파일 크기의 합이다.
 *           모든 파일을 하나로 합치는 데 필요한 최소 비용을 구하시오
 * 입력 : 첫 번째 줄 - 테스트 케이스의 개수 T
 *       각 테스트 케이스별
 *          - 첫 번째 줄 : 파일의 개수 K
 *          - 두 번째 줄 : K개의 파일 크기
 * 출력 : 각 테스트 케이스마다 파일을 하나로 합치는 최소 비용 출력
 * 문제 분석 : 항상 가장 작은 파일 두 개를 먼저 합친다.
 *           우선순위 큐(오름차순)을 활용해 하나만 남을 때까지 합산
 * 결과 : [ 368508KB / 2640ms ]
 */
public class bj13975_10_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        // 테스트 케이스별
        while (testCase-- > 0) {
            br.readLine();
            String[] sizes = br.readLine().split(" ");

            long totalCost = getTotalCost(sizes);
            sb.append(totalCost).append("\n");
        }
        System.out.print(sb);
    }

    private static long getTotalCost(String[] sizes) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (String size : sizes) {
            pq.offer(Long.parseLong(size));
        }

        // 파일 합치기 계산
        long totalCost = 0;
        while (pq.size() > 1) { // 하나의 파일로 합쳐질 때까지
            long file1 = pq.poll();
            long file2 = pq.poll();

            long sumCost = file1 + file2;
            totalCost += sumCost;

            pq.offer(sumCost); // 합친 파일을 다시 우선순위 큐에 넣는다.
        }
        return totalCost;
    }
}
