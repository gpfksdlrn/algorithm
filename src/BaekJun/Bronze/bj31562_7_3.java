package BaekJun.Bronze;

import java.io.*;
import java.util.*;

/** [ 백준 31562번 전주 듣고 노래 맞추기 ]
 * 문제 설명 : 첫 세 음만으로 노래를 맞히게 해주는 프로그램을 만들려고 한다.
 * 입력 : 첫 번째 줄에 N, 저장된 노래의 개수가 주어진다.
 *       그 후 N개의 줄에 노래의 제목과 해당 노래의 음이름이 주어진다.
 *       마지막 줄에 세 음으로 시작하는 음이름이 주어진다.
 * 출력 : 주어진 세 음으로 시작하는 노래 제목이 여러 개 있으면 ?를 출력한다.
 *       주어진 세 음으로 시작하는 노래 제목이 없으면 !를 출력한다.
 *       주어진 세음으로 시작하는 노래 제목이 하나만 있으면 그 노래 제목을 출력한다.
 * 문제 분석 : 1. 노래 개수를 입력 받는다.
 *           2. HashMap 을 통해 노래의 제목과 해당 노래의 음이름을 키-값으로 저장한다.
 * 결과 : [ 19332KB / 216ms ]
 */
public class bj31562_7_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N: 저장된 노래의 개수, M: 맞히기를 시할 노래의 개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // HashMap을 사용하여 첫 세 음과 제목을 저장
        Map<String, List<String>> songMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken(); // 제목 길이를 입력받으나 사용하지 않음
            String title = st.nextToken();
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < 3; j++) {
                sb.append(st.nextToken());
            }

            String prefix = sb.toString();

            // computeIfAbsent 는 prefix 키가 songMap 에 없으면 빈 리스트가 생성하고 추가하며, 해당 리스트를 반환합니다.
            // 반환된 리스트에 title 을 add 하여 키에 연결된 리스트에 제목을 추가한다.
            // 이를 통해 키 존재 여부를 따로 확인하지 않고 간결하게 데이터를 삽입하거나 초기화할 수 있다.
            songMap.computeIfAbsent(prefix, k -> new ArrayList<>()).add(title);
        }

        // M개의 노래 검색
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken() + st.nextToken() + st.nextToken();

            if (!songMap.containsKey(str)) {
                bw.write("!\n"); // 해당 노래 없음
            } else {
                List<String> titles = songMap.get(str);
                if (titles.size() == 1) {
                    bw.write(titles.get(0) + "\n"); // 유일한 노래
                } else {
                    bw.write("?\n"); // 중복된 노래
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
