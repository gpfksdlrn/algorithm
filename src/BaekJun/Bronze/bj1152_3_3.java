package BaekJun.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [ 백준 1152번 단어의 개수 ]
 * - 문제 설명 : 영어 대소문자와 공백으로 이루어진 문자열이 주어진다.
 *             이 문자열에는 몇 개의 단어가 있을까? 이를 구하는 프로그램을 작성하시오.
 *             단, 한 단어가 여러 번 등장하면 등장한 횟수만큼 모두 세어야 한다.
 * - 입력 : 첫 줄에 영어 대소문자와 공백으로 이루어진 문자열이 주어진다.
 *         공백이 연속해서 나오는 경우는 없고, 문자열의 앞뒤에 공백이 있을 수 있다.
 * - 출력 : 첫째 줄에 단어의 개수를 출력한다.
 * - 문제 분석
 *      1. 문자열의 앞뒤 공백을 제거한다.
 *      2. 공백을 기준으로 문자열 분리한다.
 *      3. 분리된 단어들의 개수를 세면 된다.
 * - 결과 : [ 51336KB / 260ms ]
 */
public class bj1152_3_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // trim() : 앞뒤의 공백 제거
        String str = br.readLine().trim();

        // 문자열이 빈 경우는 0, 그 외에는 공백을 기준으로 분리된 단어 개수 출력
        System.out.println(str.isEmpty()? 0 : str.split(" ").length);
    }
}

/*
시도해본 방법
1) 실패한 이유 = 배열로 처리할 경우 공백만 있는 문자열은 빈 배열로 처리되지 않고,
              하나의 빈 문자열 "[]"로 처리되어 길이가 1로 나오기 때문에 실패!!
              + 정규표현식도 좋지만 split(" ")를 해주는게 처리시간이 조금 더 빨랐다
public class bj1152_3_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // trim() : 앞뒤의 공백을 제거
        // split("\\s+") : \\s+는 정규표현식으로, \s는 공백 문자를 의미하며, +는 하나 이상을 의미한다.
        String[] strArr = br.readLine().trim().split("\\s+");

        // 단어의 개수를 출력
        System.out.println(strArr.length);
    }
}
 */