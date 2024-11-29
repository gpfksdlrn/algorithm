package BaekJun.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** [ 백준 15829번 Hashing ]
 * 문제 설명 : 주어진 문자열에 대해 특정 해시 함수를 적용하여 해시 값을 계산하는 문제
 *           문자열의 각 문자는 고유 번호로 변환되며, 이 값을 거듭제곱 계수와 곱하여 해시 값을 구한다.
 * 입력 : 첫 번째 줄에는 문자열의 길이 L
 *       두 번째 줄에는 알파벳 소문자로 구성된 문자열
 * 출력 : 해시 함수 계산 결과값을 정수로 출력
 * 결과 : [ 11516KB / 68ms ]
 */
public class bj15829_7_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        long result = 0;
        long pow = 1;

        for (int i = 0; i < L; i++) {
            result +=((str.charAt(i) - 96) * pow);
            pow = (pow * 31) % 1234567891;
        }

        System.out.println(result);
    }
}
