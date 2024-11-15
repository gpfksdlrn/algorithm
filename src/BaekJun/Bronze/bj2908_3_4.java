package BaekJun.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [ 백준 2908번 상수 ]
 * - 문제 설명 : 세 자리 수 두 개를 주고, 거꾸로 뒤집어서 두 수 중 크기가 큰 수를 출력하는 프로그램을 작성하시오.
 * - 문제 분석
 *      1. 세 자리 수를 두개 입력 받는다.
 *      2. 각 숫자를 거꾸로 읽어야 하므로, 문자열을 뒤집는다.
 *      3. 뒤집은 두 수를 비교하여 큰 값을 찾는다.
 * - 결과 : [14156KB / 108ms]
 */
public class bj2908_3_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력받은 숫자를 String 으로 받아 거꾸로 뒤집어 숫자로 형변환
        String[] numArr = br.readLine().split(" ");
        int num1 = Integer.parseInt(new StringBuilder(numArr[0]).reverse().toString());
        int num2 = Integer.parseInt(new StringBuilder(numArr[1]).reverse().toString());

        // 큰 값을 출력
        System.out.println(Math.max(num1, num2));
    }
}