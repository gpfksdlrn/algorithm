package BaekJun.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * [ 백준 7562번 나이트의 이동 ]
 * 입력 : 입력의 첫째 줄에는 테스트 케이스의 개수가 주어진다.
 *       각 테스트 케이스는 세 줄로 이루어져 있고,
 *          첫째 줄에는 체스판의 한변의 길이 l(4 <= l <= 300)이 주어진다.
 *          체스판의 크기는 l X l이다.
 *          체스판의 각 칸은 두 수의 쌍 {0, ..., l - 1} X {0, ..., l - 1}로 나타낼 수 있다.
 *          둘째 줄과 셋째 줄에는 나이트가 현재 있는 칸, 나이트가 이동하려고 하는 칸이 주어진다.
 * 출력 : 각 테스트 케이스마다 나이트가 최소 몇 번만에 이동할 수 있는지 출력한다.
 * 결과 : [ 62064KB / 224ms ]
 */
public class bj7562_나이트의_이동 {
    // 나이트가 이동 가능한 방향
    static short[] dx = {2, 2, -2, -2, 1, 1, -1, -1};
    static short[] dy = {1, -1, 1, -1, 2, -2, 2, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        short testCase = Short.parseShort(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스별
        while (testCase-- > 0) {
            short l = Short.parseShort(br.readLine());
            String[] startPoint = br.readLine().split(" ");
            String[] endPoint = br.readLine().split(" ");
            // 현재 있는 칸(출발)
            short startX = Short.parseShort(startPoint[0]);
            short startY = Short.parseShort(startPoint[1]);
            // 이동하려고 하는 칸(도착)
            short endX = Short.parseShort(endPoint[0]);
            short endY = Short.parseShort(endPoint[1]);
            // BFS 호출~
            sb.append(bfs(l, startX, startY, endX, endY)).append("\n");
        }
        // 출력
        System.out.println(sb);
    }

    /**
     * BFS 를 이용해 나이트 최소 이동 횟수를 계산하는 메서드
     *
     * @param l         체스판의 크기 (l x l)
     * @param startX    나이트의 시작 위치 X
     * @param startY    나이트의 시작 위치 Y
     * @param endX      나이트의 목표 위치 X
     * @param endY      나이트의 목표 위치 Y
     * @return          최소 이동 횟수
     */
    private static short bfs(short l, short startX, short startY, short endX, short endY) {
        // 시작 위치와 목표 위치가 같으면 이동 횟수는 0
        if (startX == endX && startY == endY) return 0;

        // 방문 여부를 기록하는 배열
        boolean[][] visited = new boolean[l][l];

        // BFS를 위한 큐(x, y, 이동 횟수)
        Queue<short[]> queue = new LinkedList<>();

        // 초기 위치 추가
        queue.offer(new short[]{startX, startY, 0});

        // 시작 위치 방문 처리
        visited[startX][startY] = true;

        // BFS 탐색
        while (!queue.isEmpty()) {
            short[] current = queue.poll(); // 큐에서 현재 위치 꺼냄
            short x = current[0];
            short y = current[1];
            short moves = current[2]; // 현재까지 이동 횟수

            // 나이트가 이동할 수 있는 가능한 방향의 개수
            for (int i = 0; i < 8; i++) {
                short nx = (short) (x + dx[i]);
                short ny = (short) (y + dy[i]);

                // 체스판 범위 내이고, 방문하지 않은 위치인 경우만 탐색
                if (nx >= 0 && ny >=0 && nx < l && ny < l && !visited[nx][ny]) {
                    // 목표 위치에 도달하면 현재 이동 횟수 + 1
                    if (nx == endX && ny == endY) return (short) (moves + 1);
                    // 큐에 새 위치와 이동 횟수를 추가
                    visited[nx][ny] = true; // 방문 처리
                    queue.offer(new short[]{nx, ny, (short) (moves + 1)});
                }
            }
        }
        // 기본적으로 실행되지 않음
        return -1;
    }
}
