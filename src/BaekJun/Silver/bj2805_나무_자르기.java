package BaekJun.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [ 백준 나무 자르기 2805번 나무 자르기 ]
 * 문제 설명 : 상근이는 나무 M 미터가 필요하다. 정부는 상근이네 집 근처의 나무 한 줄에 대한 벌목 허가를 내주었다.
 *           목재절단기에 높이 H를 지정, 그 다음 한 줄에 연속해 있는 나무를 모두 절단해버린다.
 *           따라서 높이가 H보다 큰 나무는 H 위의 부분을 잘릴 것이고, 낮은 나무는 잘리지 않을 것이다.
 *           예를 들어, 한 줄에 연속해있는 나무의 높이가 20, 15, 10, 17이라고 하자.
 *           상근이가 높이를 15로 지정했다면, 나무의 높이가 15, 15, 10, 15가 될 것이고,
 *           상근이는 길이가 5인 나무와 2인 나무를 들고 집에 갈 것이다. (총 7미터를 집에 들고 간다)
 *           적어도 M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값을 구하는 프로그램을 작성하시오.
 * 입력 : 첫째 줄 - 나무의 수 N, 상근이가 집으로 가져가려고 하는 나무의 길이 M이 주어진다.
 *               (1 <= N <= 1,000,000, 1<= M <= 2,000,000,000)
 *       둘째 줄 - 나무의 높이가 주어진다. 나무의 높이의 합은 항상 M보다 크거나 같기 때문에,
 *               상근이는 집에 필요한 나무를 항상 가져갈 수 있다. 높이는 1,000,000,000보다 작거나 같은 양의 정수 또는 0이다.
 * 출력 : 적어도 M미터의 나무를 가져가기 위해 절단기에 설정할 수 있는 높이의 최댓값을 출력한다.
 * 결과 : [ 186072KB / 564ms ]
 */

public class bj2805_나무_자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N: 나무의 수, M: 나무의 길이
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        String[] treeHeight = br.readLine().split(" ");
        int[] trees = new int[N];
        int maxTree = 0;

        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(treeHeight[i]);
            maxTree = Math.max(maxTree, trees[i]);
        }

        // 이분 탐색
        long low = 0; // 최소 높이
        long high = maxTree; // 최대 높이
        long result = 0;

        while (low <= high) {
            long mid = (low + high) / 2;
            long sum = 0;

            // 잘린 나무 길이 계산
            for (int tree : trees) {
                if (tree > mid) sum += tree - mid;
            }

            // 조건에 따라 탐색 범위 조정
            if (sum >= M)  {
                result = mid; // 높이 업데이트
                low = mid + 1; // 더 높은 높이 탐색
            } else high = mid - 1; // 낮은 높이 탐색
        }
        // 결과 출력
        System.out.println(result);
    }
}
