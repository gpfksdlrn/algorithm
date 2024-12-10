package BaekJun.Gold;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * [ 백준 10159번 저울 ]
 * 문제 설명 : 무게가 서로 다른 N개의 물건이 있다. 각 물건은 1부터 N까지 번호가 매겨져 있다.
 *           우리는 일부 물건 쌍에 대해서 양팔 저울로 어떤 것이 무거운 것인지를 측정한 결과표를 가지고 있다.
 *           이 결과표로부터 직접 측정하지 않은 물건 쌍의 비교 결과를 알아낼 수도 있고 알아내지 못할 수도 있다.
 *           예를 들어, 총 6개의 물건이 있고, 다음 5개의 비교 결과가 주어졌다고 가정하자.([1]은 1번 물건의 무게를 의미한다.)
 *           물건의 개수 N과 일부 물건 쌍의 비교 결과가 주어졌을 때, 각 물건에 대해서 그 물건과의 비교 결과를
 *           알 수 없는 물건의 개수를 출력하는 프로그램을 작성하시오.
 * 입력 : 첫 줄에는 물건의 개수 N이 주어지고, 둘째 줄에는 미리 측정된 물건 쌍의 개수 M이 주어진다.
 *       단, 5 <= N <= 100이고, 0 <= M <= 2,000이다. 다음 M개의 줄에 미리 측정된 비교 결과가 한 줄에 하나씩 주어진다.
 *       각 줄에는 측정된 물건 번호를 나타내는 두 개의 정수가 공백을 사이에 두고 주어지며, 앞의 물건이 뒤의 물건보다 더 무겁다.
 * 출력 : N개의 줄에 결과를 출력해야 한다. i번째 줄에는 물건 i 와 비교 결과를 알 수 없는 물건의 개수를 출력한다.
 * 예제 입력
6
5
1 2
2 3
3 4
5 4
6 5
 * 예제 출력
2
2
2
0
3
3
 */
public class bj10159_저울 {
    static int N, M;
    static List<Integer>[] list;
    static boolean[] visited;
    static int[] count;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 물건의 개수
        M = Integer.parseInt(br.readLine()); // 미리 측정된 물건 쌍의 개수

        // 리스트 초기화
        list = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        // 미리 측정된 비교 결과 입력
        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            String[] parts = line.split(" ");
            int a = Integer.parseInt(parts[0]); // a > b
            int b = Integer.parseInt(parts[1]); // a > b

            list[a].add(b);
        }

        // 비교 결과를 알 수 없는 물건의 개수를 출력
        count = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            dfs(i, i);
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(N - 1 - count[i]).append('\n');
        }
        System.out.print(sb);
    }

    static void dfs(int start, int cur) {
        visited[cur] = true;

        for (int next : list[cur]) {
            if (visited[next]) continue;

            count[start]++;
            count[next]++;

            dfs(start, next);
        }
    }
}