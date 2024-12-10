package BaekJun.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * [ 백준 1697번 숨바꼭질 ]
 * 문제 설명 : 수빈이는 현재 점 N(0 <= N <= 100,000)에 있고, 동생은 점(0 <= K <= 100,000)에 있다.
 *           수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
 *           순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
 *           수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
 * 입력 : 첫 번째 줄에 수빈이 위치 N과 동생이 위치 K가 주어진다.
 * 출력 : 수빈이가 동생을 찾는 가장 빠른 시간을 출력
 * 문제 분석 :
 * 결과 : [ 20804KB / 116ms ]
 */
public class bj1697_숨바꼭질 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 수빈이 위치
        int K = Integer.parseInt(input[1]); // 동생 위치

        System.out.println(bfs(N, K));
    }

    private static int bfs(int N, int K) {
        if (N == K) return 0; // 이미 같은 위치에 있다면 0초
        final int max = 100000;

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[max + 1];
        int[] time = new int[max + 1];

        queue.offer(N);
        visited[N] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            int[] nextPosition = {cur -1, cur +1, cur *2};
            for (int next : nextPosition) {
                if (next >= 0 && next <= max && !visited[next]) {
                    visited[next] = true;
                    time[next] = time[cur] + 1;
                    queue.offer(next);

                    if (next == K) return time[next];
                }
            }
        }
        return -1;
    }
}
