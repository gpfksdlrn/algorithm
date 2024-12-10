package BaekJun.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * [ 백준 1012번 유기농 배추 ]
 * 문제 설명 : 배추밭에서 서로 인접한 배추들을 그룹화하여, 각 그룹에 최소 1마리의 지렁이가 필요함을 계산한다.
 * 입력 : 첫 줄에는 테스트 케이스의 개수 T가 주어진다.
 *       그 다음 줄부터 각각의 테스트 케이스에 대해 첫째 줄에는 배추를 심은 배추밭의
 *       가로길이 M(1 <= M <= 50)과 세로길이 N(1 <= N <= 50),
 *       그리고 배추가 심어져 있는 위치의 개수 K(1 <= K <= 2500)이 주어진다.
 *       그 다음 K줄에는 배추의 위치 X(0 <= X <= M-1), Y(0 <= Y <= N-1)가 주어진다.
 *       두 배추의 위치가 같은 경우는 없다.
 * 출력 : 각 테스트 케이스에 대해 필요한 최소의 배추흰지렁이 마리 수를 출력한다.
 * 결과 : [ 14980KB / 100ms ]
 */
public class bj1012_유기농_배추 {
    static int[][] farm;        // 배추밭 배열
    static boolean[][] visited; // 방문 여부 확인
    static int M, N, K;         // 배추밭 크기와 배추 개수
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            String[] line = br.readLine().split(" ");
            M = Integer.parseInt(line[0]);
            N = Integer.parseInt(line[1]);
            K = Integer.parseInt(line[2]);
            farm = new int[M][N];
            visited = new boolean[M][N];

            for (int i = 0; i < K; i++) {
                String[] position = br.readLine().split(" ");
                int x = Integer.parseInt(position[0]);
                int y = Integer.parseInt(position[1]);
                farm[x][y] = 1; // 배추가 심어진 위치
            }

            int wormCnt = 0;

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (farm[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        wormCnt++;
                    }
                }
            }
            sb.append(wormCnt).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = currentX + dx[i];
                int ny = currentY + dy[i];

                if (nx >= 0 && ny >= 0 && nx < M && ny < N &&
                    farm[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
