package BaekJun.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [ 백준 26041번 비슷한 전화번호 표시 ]
 * - 문제 설명 :
 *      1. 문자열 A에 포함된 전화번호 중 B와 다르지만 B를 접두사로 갖는 전화번호의 개수를 출력한다.
 * - 입력
 *      1. 첫 번째 줄의 문자열 A : n개의 전화번호가 공백으로 구분되어 주어진다.
 *      2. 두 번째 줄의 문자열 B : 하나의 전화번호
 * - 문제 분석
 *      1. 전화번호 분리 : A를 공백 기준으로 분리해 리스트로 만든다.
 *      2. 전화번호 리스트에서 중복을 제거한다.
 *      3. 각 고유의 전화번호를 문자열 B와 비교하여, B와 다르면서 B의 접두사로 시작하는 전화번호 찾기
 *      4. 조건을 만족하는 전화번호 개수를 계산하여 출력한다.
 * - 결과 : [ 27348KB / 276ms ]
 */
public class bj26041_3_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] A = br.readLine().split(" ");
        String B = br.readLine();

        int count = 0; // 접두사로 시작하는 전화번호 카운트

        for (String phone : A) {
            if (!phone.equals(B) && phone.startsWith(B)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
