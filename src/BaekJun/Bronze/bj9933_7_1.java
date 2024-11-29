package BaekJun.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/** [ 백준 9933번 민균이의 비밀번호 ]
 * 문제 설명 : 비밀번호가 모두 주어졌을 때,
 *           각 비밀번호를 확인하며, 그 비밀번호를 뒤집은 형태가 목록에 있는지 확인
 *           조건을 만족하는 비밀번호를 찾으면, 비밀번호의 길이와 가운데 글자를 출력하는 프로그램을 작성하시오.
 * 입력 : 첫째 줄에 단어의 수 N (2 <= N <= 100)이 주어진다.
 *       다음 N개 줄에는 파일에 적혀있는 단어가 한 줄에 하나씩 주어진다.
 *       단어는 알파벳 소문자로만 이루어져 있으며, 길이는 2보다 크고 14보다 작은 홀수이다.
 * 출력 : 첫째 줄에 비밀번호의 길이와 가운데 글자를 출력한다. 항상 답이 유일한 경우만 입력으로 주어진다.
 * 문제 분석 : 1.	단어들을 저장할 자료구조 생성 (Hash Table)
 * 	         2.	각 단어에 대해 해당 단어를 뒤집은 문자열이 목록에 있는지 확인
 * 	         3.	조건을 만족하는 단어를 찾으면 그 단어의 길이 출력, 가운데 글자 출력
 * 결과 : [ 11576KB / 64ms ]
 */
public class bj9933_7_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        String result = "";

        // HashSet - 중복을 허용하지 않는 데이터 집합
        // 특징 : 중복 데이터 제거 / 순서 없음 / 빠른 검색 및 삽입 / 기반 구조
        Set<String> words = new HashSet<>();
        for (int i = 0; i < count; i++) {
            words.add(br.readLine());
        }

        // 역순 탐색
        for (String word : words) {
            String reversedWord = new StringBuilder(word).reverse().toString();
            if (words.contains(reversedWord)) {
                result = word;
                break;
            }
        }
        br.close();

        // 결과 출력
        int length = result.length();
        char midChar = result.charAt(length / 2);
        System.out.println(length + " " + midChar);

    }
}
