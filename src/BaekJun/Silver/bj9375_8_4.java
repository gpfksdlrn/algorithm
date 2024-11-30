package BaekJun.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * [ 백준 9375번 패션왕 신해빈 ]
 * 문제 설명 : 해빈이는 같은 의상 조합을 절대 반복하지 않는다.
 *           의상을 최소 1개 이상 착용한 상태로 외출할 수 있어야 한다.
 *           주어진 의상 목록에서 각 종류의 의상을 조합하여 해빈이가 알몸이 아닌 상태로 외출할 수 있는 경우의 수를 계산한다.
 * 입력 : 첫 번째 줄 - 테스트 케이스의 수 T (최대 100개)
 *       이후 n개의 줄 - 의상의 이름과 종류가 공백으로 구분되어 주어짐
 *                    같은 종류의 의상은 하나만 입을 수 있음
 * 출력 : 테스트 케이스마다 해빈이가 알몸이 아닌 상태로 외출할 수 있는 경우의 수를 출력
 * 결과 : [ 11896KB / 72ms ]
 */
public class bj9375_8_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> clothMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                String type = input[1]; // 의상 종류
                clothMap.put(type, clothMap.getOrDefault(type, 0) + 1);
            }

            int result = 1;

            // 의상 종류마다 (선택 가능 개수 + 1)을 곱함
            for (int count : clothMap.values()) {
                result *= (count + 1);
            }

            // 알몸 상태에 제외해야 하므로 1을 뺌
            sb.append(result - 1).append("\n");
        }
        System.out.println(sb);
    }
}
