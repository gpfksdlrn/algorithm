package BaekJun.Silver;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * [ 백준 25593번 근무 지옥에 빠진 푸앙이 (Small) ]
 * - 주어진 시간표대로 근무할 때, 모든 인원이 공평하게(차이가 12시간 이하로) 근무했다면 YES, 아니면 NO를 출력
 * - 한 주에 4개의 시간 타임이 7일 동안 반복된다.
 * - 만약 근무자가 없다면 map에 저장하지 않고 근무자가 있다면 map에 근무 시간을 추가해준다.
 * - 결과 : [ 14868KB / 120ms ]
 */

/** 근무표
 * 첫 번째 주 근무표
 *    1     |   2    |   3   |    4    |    5   |   6     |   7
 *    -     |   -    |   -   |    -    |    -   | pangyo  | puang   > 08 ~ 12시 근무자, 4
 *    -     |   -    |   -   |    -    |    -   | sally   | boss    > 12 ~ 18시 근무자, 6
 *    -     |   -    |   -   |    -    |    -   | leonard | brown   > 18 ~ 22시 근무자, 4
 *    -     |   -    |   -   |    -    |    -   | edward  | edward  > 22 ~ 08시 근무자, 10

 *  두 번째 주 근무표
 *  puang   | pangyo | choco | leonard | cony   | leonard | choco   > 08 ~ 12시 근무자, 4
 *  cony    | edward | cony  | leonard | moon   | puang   | edward  > 12 ~ 18시 근무자, 6
 *  choco   | boss   | puang | brown   | brown  | pangyo  | cony    > 18 ~ 22시 근무자, 4
 *  choco   | edward | puang | cony    | moon   | choco   | boss    > 22 ~ 08시 근무자, 10

 *  세 번째 주 근무표
 *  brown   | moon   | moon  | sally   | pangyo | puang   | choco   > 08 ~ 12시 근무자, 4
 *  pangyo  | edward | boss  | sally   | moon   | cony    | pangyo  > 12 ~ 18시 근무자, 6
 *  brown   | puang  | james | moon    | cony   | choco   | choco   > 18 ~ 22시 근무자, 4
 *  sally   | brown  | sally | puang   | james  | moon    | sally   > 22 ~ 08시 근무자, 10

 *  네 번째 주 근무표
 *  leonard | pangyo |   -   |    -    |    -   |    -    |   -     > 08 ~ 12시 근무자, 4
 *  boss    | choco  |   -   |    -    |    -   |    -    |   -     > 12 ~ 18시 근무자, 6
 *  moon    | edward |   -   |    -    |    -   |    -    |   -     > 18 ~ 22시 근무자, 4
 *  moon    | sally  |   -   |    -    |    -   |    -    |   -     > 22 ~ 08시 근무자, 10
 */
public class bj25593_4_3 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            // 시간대별 근무 시간
            int[] partTime = {4, 6, 4, 10};

            // 근무 시간 저장할 Map
            Map<String, Integer> map = new HashMap<>();

            // 주차 수 입력
            int weeks = Integer.parseInt(br.readLine());
            StringTokenizer st;
            String name;

            // 주의 개수만큼 반복
            while (weeks-- > 0) {
                // 4개의 시간대
                for (int k : partTime) {
                    st = new StringTokenizer(br.readLine());
                    // 한 주에 7일
                    for (int j = 0; j < 7; j++) {
                        name = st.nextToken();
                        if (!name.equals("-")) { // 근무자가 없는 경우
                            map.put(name, map.getOrDefault(name, 0) + k);
                        }
                    }
                }
            }

            // 근무시간이 공평한지 여부 검증
            if (map.isEmpty()) {
                bw.write("Yes");
            } else {
                int min = Collections.min(map.values());
                int max = Collections.max(map.values());

                bw.write(max - min <= 12 ? "Yes" : "No");
            }
            bw.flush();
        }
    }
}
