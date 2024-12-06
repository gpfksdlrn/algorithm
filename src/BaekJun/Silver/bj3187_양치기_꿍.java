package BaekJun.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * [ 백준 3187번 양치기 꿍 ]
 * 문제 설명 : 양치기 꿍이 울타리 안에 양(k)과 늑대(v)를 집어 넣었다.
 *           - 한 울타리 영역 안에서 양의 수 > 늑대의 수일 경우, 늑대가 전부 잡아먹힌다.
 *           - 반대로 늑대의 수 >= 양의 수일 경우, 양이 전부 잡아먹힌다.
 *           - 울타리(#)로 막히지 않은 공간에는 양과 늑대가 존재하지 않으며, 대각선 이동은 불가능하다.
 *           문제는 최종적으로 살아남은 양과 늑대의 수를 계산하는 것이다.
 * 입력 : 첫 줄 - 영역의 세로(R)와 가로(C) 길이를 나타내는 두 정수
 *              3 <= R, C <= 250
 *       다음 R줄 - 각 줄에 .(빈 공간), #(울타리), v(늑대), k(양)로 구성된 문자
 * 출력 : 한 줄에 최종적으로 살아남은 양의 수와 늑대의 수를 공백으로 구분하여 출력한다.
 * 입력 예제
 6 6
...#..
.v.#.#
.#.k.#
.###.#
.#k.v#
...###
 * 출력 예제
3 1

 * 결과 : [ 18012KB / 132ms ]
 */
public class bj3187_양치기_꿍 {
    static int R, C;
    static boolean[][] visited;
    static char[][] map;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에서 세로(R)와 가로(C)의 크기 읽기
        String[] firstLine = br.readLine().split(" ");
        R = Integer.parseInt(firstLine[0]);
        C = Integer.parseInt(firstLine[1]);

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // visited 배열 선언
        visited = new boolean[R][C];
        int totalSheep = 0, totalwolf = 0;

        // 그리드 순회하며 영역별로 BFS 실행
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != '#' && !visited[i][j]) {
                    int[] result = bfs(i, j);
                    int sheep = result[0];
                    int wolf = result[1];

                    // 양이 더 많으면 양이 살아남고, 늑대가 더 많으면 늑대가 살아남음
                    if (sheep > wolf) totalSheep += sheep;
                    else totalwolf += wolf;
                }
            }
        }
        // 최종적으로 살아남은 양과 늑대의 수 출력
        System.out.println(totalSheep + " " + totalwolf);
    }

    private static int[] bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        int sheep = 0, wolf = 0;

        if (map[x][y] == 'k') sheep++;
        if (map[x][y] == 'v') wolf++;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < R && ny < C && !visited[nx][ny] && map[nx][ny] != '#') {
                    visited[nx][ny] = true;
                    if (map[nx][ny] == 'k') sheep++;
                    if (map[nx][ny] == 'v') wolf++;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return new int[]{sheep, wolf};
    }
}
