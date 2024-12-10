package BaekJun.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * [ 백준 24444번 너비 우선 탐색 1 ]
 * 문제 설명 : N개의 정점과 M개의 간선으로 구성된 무방향 그래프(undirected graph)가 주어진다.
 *           정점 번호는 1번부터 N번이고 모든 간선의 가중치는 1이다.
 *           정점 R에서 시작하여 너비 우선 탐색으로 노드를 방문할 경우 노드의 방문 순서를 출력하자.
 *           인접 정점은 오름차순으로 방문한다.
 * 입력 : 정점 수 N(5 ≤ N ≤ 100,000), 간선 수 M(1 ≤ M ≤ 200,000), 시작 정점 R(1 ≤ R ≤ N)
 *       간선 정보 u, v(정점 u 와 v 를 연결하는 양방향 간선)
 * 출력 : 총 N 개의 줄 출력
 *       i 번째 줄에 정점 i 의 방문 순서 출력
 *       방문하지 못한 경우 0 출력
 * 문제 분석 : 간선 정보를 인접 리스트로 저장, 인접 정점은 오름차순 정렬 후 탐색
 *           BFS 사용하며 큐 활용
 *           방문 순서를 배열에 기록
 *           각 정점의 방문 순서를 출력하며, 방문하지 못한 경우 0 출력
 * 결과 : [ 113640KB / 916ms ]
 */
public class bj24444_너비_우선_탐색_1 {
    static int N, M, R; // 정점의 수, 간선의 수, 시작 정점
    static ArrayList<Integer>[] graph; // 그래프 인접 리스트
    static int[] visited; // 방문 순서를 저장할 배열
    static int order = 1; // 방문 순서 카운트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]); // 정점의 수
        M = Integer.parseInt(input[1]); // 간선의 수
        R = Integer.parseInt(input[2]); // 시작 정점

        graph = new ArrayList[N + 1];
        visited = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 정보 입력 받기
        for (int i = 0; i < M; i++) {
            String[] edges = br.readLine().split(" ");
            int u = Integer.parseInt(edges[0]);
            int v = Integer.parseInt(edges[1]);

            // 양방향 간선 추가
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        // BFS 수행
        bfs(R);

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = order++; // 시작 정점 방문 순서 기록

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph[current]) {   // 인접 정점을 순회
                if (visited[next] == 0) {   // 방문하지 않은 정점이라면
                    visited[next] = order++; // 방문 순서 기록
                    queue.add(next); // 큐에 추가
                }
            }
        }
    }
}
