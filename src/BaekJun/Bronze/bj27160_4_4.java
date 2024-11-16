package BaekJun.Bronze;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * [ 백준 27160번 할리갈리 ]
 *  - 입력
 *      1. 첫 번째 줄에 펼쳐진 카드의 개수 N이 주어진다.
 *      2. 두 번째 줄부터 N개의 줄에 걸쳐 한 줄에 하나씩 펼쳐진 카드의 정보가 주어진다.
 *      3. 카드의 정보는 공백으로 구분된, 과일의 종류를 나타내는 문자열 S와 과일의 개수를 나타내는 양의 정수 X로 이루어져 있다.
 *      4. S는 STRAWBERRY, BANANA, LIME, PLUM 중 하나이다.
 * - 출력 : 한별이가 종을 쳐야하면 YES, 아니면 NO
 * - 문제 분석 : 입력으로 과일과 갯수를 받아서 합이 5인 과일 한 종류라도 있으면 YES 아니면 NO
 * - 결과 : [ 40300KB / 348ms ]
 */
public class bj27160_4_4 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st;
            // 카드의 개수
            int count = Integer.parseInt(br.readLine());

            // 과일 이름과 개수를 지정하는 map
            HashMap<String, Integer> fruit = new HashMap<>();

            for (int i = 0; i < count; i++) {
                st = new StringTokenizer(br.readLine());
                String fruitName = st.nextToken();
                int fruitCount = Integer.parseInt(st.nextToken());

                // getOrDefault = fruitName이 map에 없으면 기본값으로 지정한 0을 반환
                fruit.put(fruitName, fruit.getOrDefault(fruitName, 0) + fruitCount);
            }

            // 과일 중 총 개수가 5인 경우 확인
            boolean result = fruit.containsValue(5);
            bw.write(result ? "YES" : "NO");
            bw.flush();
        }
    }
}
