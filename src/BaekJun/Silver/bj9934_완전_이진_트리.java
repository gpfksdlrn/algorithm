package BaekJun.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * [ 백준 9934번 완전 이진 트리 ]
 * 문제 설명 : 깊이 K인 완전 이진 트리에서 중위 순회로 방문한 빌딩 번호가 주어졌을 때,
 *           각 레벨에 있는 빌딩 번호를 구하는 문제이다.
 * 입력 : 1.	첫 번째 줄: 트리의 깊이 K (1 ≤ K ≤ 10)
 * 	     2.	두 번째 줄: 중위 순회로 방문한 빌딩 번호가 공백으로 구분된 정수로 주어짐.
 *      (총 2^K - 1개의 빌딩 번호, 중복 없음)
 * 출력 : 총 K개의 줄에 걸쳐, 각 레벨에 위치한 빌딩 번호를 왼쪽에서 오른쪽 순으로 출력.
 * 결과 : [ 12948KB / 96ms ]
 */
public class bj9934_완전_이진_트리 {
    static short[] buildings; // 빌딩 번호
    static List<List<Short>> levels;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        short K = Short.parseShort(br.readLine());

        // 빌딩 번호 입력
        String[] input = br.readLine().split(" ");
        buildings = new short[input.length];
        for (int i = 0; i < input.length; i++) {
            buildings[i] = Short.parseShort(input[i]);
        }

        // 레벨을 저장할 리스트 초기화
        levels = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            levels.add(new ArrayList<>());
        }

        // 트리를 구성 (중위 순회 기반으로 레벨 저장)
        buildTree(0, buildings.length -1, 0);

        // 레벨별 출력
        for (List<Short> level : levels) {
            for (Short building : level) {
                System.out.print(building + " ");
            }
            System.out.println();
        }
    }

    /**
     * 트리 구성 및 레벨에 빌딩 번호 저장
     *
     * @param start 현재 구간의 시작 인덱스
     * @param end   현재 구간의 끝 인덱스
     * @param depth 현재 깊이 (레벨)
     */
    private static void buildTree(int start, int end, int depth) {
        if (start > end) return; // 구간이 유효하지 않으면 종료

        int mid = (start + end) / 2; // 중간값(루트 노드)
        levels.get(depth).add(buildings[mid]); // 현재 깊이에 빌딩 번호 저장

        // 왼쪽 서브트리 처리
        buildTree(start, mid - 1, depth + 1);

        // 오른쪽 서브트리 처리
        buildTree(mid + 1, end, depth + 1);
    }
}