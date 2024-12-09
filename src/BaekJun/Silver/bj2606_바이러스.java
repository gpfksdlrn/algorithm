package BaekJun.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * [ 백준 2606번 바이러스 ]
 * 문제 설명 : 연결되어 있는 모든 컴퓨터는 웜 바이러스에 걸리게 된다.
 *           예를 들어 1번 컴퓨터가 웜 바이러스에 걸렸다. 컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질때,
 *           1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을 작성하시오.
 * 입력 : 첫째 줄에는 컴퓨터의 수가 주어진다. 컴퓨터의 수는 100 이하인 양의 정수이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다.
 *       둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다.
 *       이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.
 * 출력 : 1번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 첫째 줄에 출력한다.
 * 결과 : [ 11788KB / 72ms ]
 */
public class bj2606_바이러스 {
    // 컴퓨터의 수 computerCnt
    // 간선의 수 edge
    static short computerCnt;
    static List<List<Short>> graph;
    static boolean[] visited;
    static short zombieCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        computerCnt = Short.parseShort(br.readLine());
        short edgeCnt = Short.parseShort(br.readLine());

        // 그래프 초기화
        graph = new ArrayList<>();
        // 방문 배열 초기화
        visited = new boolean[computerCnt + 1];

        for (int i = 0; i <= computerCnt; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 입력
        for (int i = 0; i < edgeCnt; i++) {
            String[] line = br.readLine().split(" ");
            short a = Short.parseShort(line[0]);
            short b = Short.parseShort(line[1]);

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        bfs((short) 1);

        System.out.println(zombieCnt - 1); // 자기 자신 제외
    }

    private static void bfs(short start) {
        Queue<Short> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        zombieCnt = 0;

        while (!queue.isEmpty()) {
            short cur = queue.poll();
            zombieCnt++;

            for (int next : graph.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer((short) next);
                }
            }
        }
    }
}
