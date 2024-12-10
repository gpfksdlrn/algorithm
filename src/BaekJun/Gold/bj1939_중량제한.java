package BaekJun.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * [ 백준 1939번 중량제한 ]
 * 문제 설명 : N(2 <= N <= 10,000)개의 섬으로 이루어진 나라가 있다.
 *           두 섬(공장이 위치한 섬) 사이에 가능한 경로 중 옮길 수 있는 물품의 중량의 최댓값을 구한다.
 * 입력 : 첫째 줄에 N, M(1 <= M <= 100,000), 다음 M개의 줄에는
 *       다리에 대한 정보를 나타내는 세 정수 A, B, C가 주어진다.
 *       이는 A번 섬과 B번 섬 사이에 중량 제한이 C인 다리가 있다.
 *       서로 같은 두 섬 사이에 여러 개의 다리가 있을 수도 있으며, 모든 다리는 양방향이다.
 *       마지막 줄에는 공장이 위치해 있는 섬의 번호를 나타내는 서로 다른 두 정수가 주어진다.
 *       공장이 있는 두 섬을 연결하는 경로는 항상 존재하는 데이터만 입력으로 주어진다.
 * 결과 : [ 79064KB / 568ms ]
 */
public class bj1939_중량제한 {
    static class Edge {
        int to;
        int weight;
        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static int N, M;
    static List<Edge>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] bridgeInfo = br.readLine().split(" ");
            int A = Integer.parseInt(bridgeInfo[0]);
            int B = Integer.parseInt(bridgeInfo[1]);
            int C = Integer.parseInt(bridgeInfo[2]);

            // 양방향
            graph[A].add(new Edge(B, C));
            graph[B].add(new Edge(A, C));
        }

        // 공장이 위치한 두 섬
        String[] island = br.readLine().split(" ");
        int factory1 = Integer.parseInt(island[0]);
        int factory2 = Integer.parseInt(island[1]);

        int result = maxWeight(factory1, factory2);

        System.out.println(result);
    }

    private static int maxWeight(int factory1, int factory2) {
        int low = 1;
        int high = 1000000000;
        int result = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (bfs(factory1, factory2, mid)) {
                result = mid;
                low = mid + 1;      // 더 큰 중량을 시도
            } else high = mid - 1;  // 중량 제한을 줄여서 다시 시도
        }

        return result;
    }

    private static boolean bfs(int factory1, int factory2, int mid) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(factory1);
        visited[factory1] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (Edge edge : graph[current]) {
                if (!visited[edge.to] && edge.weight >= mid) {
                    if (edge.to == factory2) {
                        return true;
                    }
                    visited[edge.to] = true;
                    queue.offer(edge.to);
                }

            }
        }
        return false;
    }
}
