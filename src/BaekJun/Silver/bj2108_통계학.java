package BaekJun.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * [ 백준 2108번 통계학 ]
 * 문제 설명 : N은 홀수라고 가정한다.
 *           1. 산술평균 : N개의 수들의 합을 N으로 나눈 값
 *           2. 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
 *           3. 최빈값 : N개의 수들 중 가장 많이 나타나는 값
 *           4. 범위 : N개의 수들 중 최댓값과 최솟값의 차이
 *           N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.
 * 입력 : 첫째 줄에 N(1 <= N <= 500,000)이 주어진다. 단, N은 홀수이다.
 *       그 다음 N개의 줄에는 정수들이 주어진다. 입력되는 정수의 절댓값은 4,000을 넘지 않는다.
 * 출력 : 첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.
 *       둘째 줄에는 중앙값을 출력한다.
 *       셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
 *       넷째 줄에는 범위를 출력한다.
 * 결과 : [ 66440KB / 616ms ]
 */
public class bj2108_통계학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // 산술평균 (N개의 수들의 합을 N으로 나눈 값)
        double avg = (double) sum / N;
        sb.append(Math.round(avg)).append("\n");

        // 중앙값 (N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값)
        Arrays.sort(nums);
        int mid = nums[N / 2];
        sb.append(mid).append("\n");

        // 최빈값 (N개의 수들 중 가장 많이 나타나는 값, 여러 개 있을 때에는 두 번째로 작은 값을 출력)
        int maxFrequency = Collections.max(map.values());
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                list.add(entry.getKey());
            }
        }

        Collections.sort(list);
        int mode = list.size() > 1 ? list.get(1) : list.get(0);
        sb.append(mode).append("\n");

        // 범위 (N개의 수들 중 최댓값과 최솟값의 차이)
        int range = nums[N-1] - nums[0];
        sb.append(range).append("\n");

        System.out.println(sb);
    }
}
