package BaekJun.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * [ 백준 2210번 숫자판_점프 ]
 * 문제 설명 : 5 * 5 크기의 숫자판에서 임의의 위치에서 시작하여 인접한 네 방향(상, 하, 좌, 우)으로 이동하며
 *          6자리 숫자를 만든다. 같은 칸을 여러 번 거쳐도 되고, 숫자는 0으로 시작해도 된다.
 *          만들 수 있는 서로 다른 6자리 수의 개수를 구하시오.
 * 입력 : 5개의 줄에 5개의 정수(0~9)가 공백으로 구분되어 주어진다.
 * 출력 : 만들 수 있는 서로 다른 6자리 수의 개수를 출력한다.
 * 결과 : [ 18264KB / 136ms ]
 */
public class bj2210_숫자판_점프 {
    static int[][] board = new int[5][5];
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};
    static Set<String> uniqueNumbers = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 숫자판 입력
        for (int i = 0; i < 5; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        // 모든 칸에서 BFS 시작
        for (int k = 0; k < 5; k++) {
            for (int l = 0; l < 5; l++) {
                bfs(k, l);
            }
        }

        // 결과 출력: 서로 다른 6자리 수의 개수
        System.out.println(uniqueNumbers.size());
    }

    private static void bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 1, board[startX][startY]});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int length = current[2];
            StringBuilder sb = new StringBuilder(Integer.toString(current[3]));

            if (length == 6) {
                uniqueNumbers.add(sb.toString());
                continue;
            }

            // 네 방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
                    StringBuilder nextSb = new StringBuilder(sb); // 현재 상태 복사
                    nextSb.append(board[nx][ny]); // 다음 숫자 추가
                    queue.add(new int[]{nx, ny, length + 1, Integer.parseInt(nextSb.toString())});
                }
            }
        }
    }
}
