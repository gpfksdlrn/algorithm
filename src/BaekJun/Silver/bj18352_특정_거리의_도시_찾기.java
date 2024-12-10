package BaekJun.Silver;

import java.util.*;
import java.io.*;

/**
 * [ 백준 18352번 특정 거리의 도시 찾기 ]
 * 문제 설명 : 어떤 나라에는 1번부터 N 번까지의 도시와 M개의 단방향 도로가 존재한다. 모든 도로의 길이는 1이다.
 *           특정한 도로 X 에서 최단 거리가 정확히 K인 도시들의 번호를 출력하는 프로그램을 작성하시오.
 *           최단 거리 = 도시 X에서 출발한 후의 이동 횟수
 * 입력 : 첫째 줄 - 도시의 수(정점) N, 도로 수(간선) M, 출발 도시 X
 *       둘째 줄 - 단방향 도로 정보 A, B(A번 도시에서 B번 도시로 이동 가능)
 * 출력 : 최단 거리가 K인 도시 번호를 한 줄에 하나씩 오름차순으로 출력
 *       K인 도시가 없으면 -1 출력
 * 결과 : [ 333192KB / 1192ms ]
 * 1 -> 2, 3
 * 2 -> 3, 4
 */
public class bj18352_특정_거리의_도시_찾기 {
    static int N, M, K, X;
    static List<List<Integer>> graph; // 인접 리스트 선언
    static int[] distances;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        // N(도시 수), M(도로 수), K(거리 정보), X(출발 도시)
        N = Integer.parseInt(firstLine[0]);
        M = Integer.parseInt(firstLine[1]);
        K = Integer.parseInt(firstLine[2]);
        X = Integer.parseInt(firstLine[3]);

        // 그래프 인접 리스트 초기화
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 도로 수(간선) 정보 입력
        for (int i = 0; i < M; i++) {
            String[] edge = br.readLine().split(" ");
            int A = Integer.parseInt(edge[0]);
            int B = Integer.parseInt(edge[1]);
            // A에서 B로 가는 간선 추가
            // graph: 0: [[], 1: [2, 3], 2: [3, 4], 3: [], 4: []]
            graph.get(A).add(B);
        }

        // 거리 배열 초기화
        distances = new int[N + 1];
        // distances: [-1, -1, -1, -1, -1]
        Arrays.fill(distances, -1);

        // BFS 시작
        bfs(X);

        StringBuilder sb = new StringBuilder();
        boolean found = false;
        for (int i = 1; i <= N; i++) {
            if (distances[i] == K) {
                sb.append(i).append("\n");
                found = true;
            }
        }

        if (!found) {
            sb.append("-1\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        distances[start] = 0;
        // queue: [1]
        // distances: [-1, 0, -1, -1, -1]

        while (!queue.isEmpty()) {
            int current = queue.poll();
            // graph.get(current)가 반환하는 값은 List<Integer> 형식
            // 예를 들어, graph.get(3)은 도시 3에서 이동 가능한 도시들의 리스트
            for (int next : graph.get(current)) {
                if (distances[next] == -1) { // 아직 방문하지 않은 노드
                    distances[next] = distances[current] + 1;
                    queue.offer(next);
                }
            }
        }
    }
}