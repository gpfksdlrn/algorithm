package BaekJun.Silver;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

/**
 * [ 백준 20291번 파일 정리 ]
 * - 문제 설명
 *      1. 파일을 확장자 별로 정리해서 몇 개씩 있는지 알려줘
 *      2. 보기 편하게 확장자들을 사전 순으로 정렬해줘
 * - 입력
 *      1. 첫째 줄에 바탕화면에 있는 파일의 개수 N이 주어진다. (1 <= N <= 50000)
 *      2. 둘째 줄부터 N개 줄에 바탕화면에 있는 파일의 이름이 주어진다.
 *      3. 파일의 이름은 알파벳 소문자와 점(.)으로만 구성되어 있다.
 *      4. 점은 정확히 한 번 등장하며, 파일 이름의 첫 글자 또는 마지막 글자로 오지 않는다. 각 파일의 이름의 길이는 최소 3, 최대 100이다.
 * - 출력
 *      1. 확장자의 이름과 그 확장자 파일의 개수를 한 줄에 하나씩 출력한다.
 *      2. 확장자가 여러 개 있는 경우 확장자 이름의 사전순으로 출력한다.
 * - 결과 : [ 65292KB / 656ms ]
 */
public class bj20291_3_5 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringBuilder sb = new StringBuilder();

            // 파일 개수 입력
            int n = Integer.parseInt(br.readLine());

            // 확장자별 파일 개수를 저장할 TreeMap (자동으로 사전순 정렬됨)
            Map<String, Integer> extensionCount = new TreeMap<>();

            // 파일 이름 읽고 확장자 카운팅
            for (int i = 0; i < n; i++) {
                String[] parts = br.readLine().split("\\.");

                // 확장자 개수 업데이트
                // merge 메서드는 값이 없을 때 초기값을 설정하고, 이미 값이 있을 때는 지정된 함수로 업데이트합니다.
                extensionCount.merge(parts[1], 1, Integer::sum);
            }

            // 결과 출력
            for (Map.Entry<String, Integer> entry : extensionCount.entrySet()) {
                sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
            }
            bw.write(String.valueOf(sb));
            bw.flush();
        }
    }
}
