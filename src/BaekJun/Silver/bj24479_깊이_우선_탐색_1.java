package BaekJun.Silver;

import java.util.*;
import java.io.*;

/**
 * [ 백준 24479번 알고리즘 수업 - 깊이 우선 탐색 1 ]
 * 문제 설명 : N개의 정점과 M개의 간선으로 구성된 무방향 그래프(undirected graph)가 주어진다.
 *           정점 번호는 1번부터 N 번이고 모든 간선의 가중치는 1이다.
 *           정점 R에서 시작하여 깊이 우선 탐색으로 노드를 방문할 경우 노드의 방문 순서를 출력하자.
 *           인접 정점은 오름차순으로 방문한다.
 * 입력 : 첫째 줄에 정점의 수 N(5 <= N <= 100,000), 간선의 수 M(1 <= M <= 200,000), 시작 정점 R(1 <= R <= N)이 주어진다.
 *       다음 M개 줄에 간선 정보 u v가 주어지며 정점 u와 정점 v의 가중치 1인 양방향 간선을 나타낸다.
 *       (1 ≤ u < v ≤ N, u ≠ v) 모든 간선의 (u, v) 쌍의 값은 서로 다르다.
 * 출력 :첫째 줄부터 N개의 줄에 정수를 한 개씩 출력한다.
 *      i번째 줄에는 정점 i의 방문 순서를 출력한다. 시작 정점의 방문 순서는 1이다. 시작 정점에서 방문할 수 없는 경우 0을 출력한다.
 * 문제 분석 : 간선 정보를 읽어와 인접 리스트 생성 후 정렬
 *           DFS 를 수행하며 방문 순서를 visited 배열에 저장
 * 결과 : [ 112868KB / 876ms ]
 */
public class bj24479_깊이_우선_탐색_1 {
    static int N, M, R; // 정점의 수, 간선의 수, 시작 정점
    static ArrayList<Integer>[] graph; // 그래프 인접 리스트
    static int[] visited; // 방문 순서를 저장할 배열
    static int order = 1; // 방문 순서 카운트

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]); // 정점의 수
        M = Integer.parseInt(input[1]); // 간선의 수
        R = Integer.parseInt(input[2]); // 시작 정점

        graph = new ArrayList[N+1];
        visited = new int[N+1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 정보 입력 받기 (u, v)
        for (int i = 0; i < M; i++) {
            String[] edges = br.readLine().split(" ");
            int u = Integer.parseInt(edges[0]);
            int v = Integer.parseInt(edges[1]);
            // 두 정점이 서로 연결되었다는 정보를 명시적으로 저장
            graph[u].add(v);
            graph[v].add(u);
        }

        // 오른차순 정렬
        for (int i = 1; i <=N; i++) {
            Collections.sort(graph[i]);
        }

        // DFS 수행
        dfs(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int node) {
        visited[node] = order++; // 방문 순서 기록
        for (int next : graph[node]) {
            if (visited[next] == 0) { // 방문하지 않은 노드라면
                dfs(next);
            }
        }
    }
}
