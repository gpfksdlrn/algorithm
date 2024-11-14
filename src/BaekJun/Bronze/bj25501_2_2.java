package BaekJun.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [ 백준 25501번 재귀의 귀재 ]
 * - 문제 설명
 *      1. 팰린드롬은 앞에서부터 읽었을 때와 뒤에서부터 읽었을 때가 같은 문자열을 의미한다.
 *      2. 예시: 팰린드롬의 예시로 "AAA", "ABBA", "ABABA" 등이 있고,
 *              팰린드롬이 아닌 예시로 "ABCA", "PALINDROME" 등이 있다.
 *      3. 문자열이 팰린드롬인지 판별하기 위해 재귀 함수 isPalindrome를 구현하여
 *         판별 과정을 수행하고, 해당 과정에서 재귀 함수 호출 횟수를 센다.
 * - 입력
 *      1. 첫째 줄에 테스트케이스의 개수 T가 주어진다. (1 <= T <= 1000)
 *      2. 둘째 줄부터 T개의 줄에 알파벳 대문자로 이루어진 문자열 S가 주어진다. (1 <= |S| <= 1000)
 * - 출력
 *      1. 각 테스트케이스마다 문자열이 팰린드롬이면 1을, 아니면 0을 반환하고, 재귀 함수 recursion의 호출 횟수를 함께 출력합니다.
 *      2. 각 테스트케이스 결과를 한 줄에 반환값과 호출 횟수를 공백으로 구분하여 출력합니다.
 * - 문제 분석
 *      1. 문자열이 팰리드롬인지 판별하는 기본 구조는 재귀를 사용한다.
 *      2. 왼쪽 끝 문자와 오른쪽 끝 문자를 비교하고, 다르면 0, 같으면 재귀 호출을 통해 다음 문자들을 비교한다.
 *      3. 중간 지점에 도달하면 팰린드롬임이 확정되므로 1을 반환한다.
 *      4. 재귀 호출 횟수를 구하기 위해 호출 시마다 카운트를 증가시키도록 구현한다.
 * - 결과 [ 20780KB / 268ms ]
 */
public class bj25501_2_2 {

    private static int recursionCount;

    // 재귀 호출 방식으로 팰린드롬 판별
    private static int recursion(String str, int l, int r) {
        recursionCount++;
        if (l >= r) return 1; // 중간까지 도달하면 팰린드롬이다.
        else if (str.charAt(l) != str.charAt(r)) return 0; // 양 끝 문자가 다르면 팰린드롬 아니다.
        else return recursion(str, l + 1, r - 1); // 양 끝이 같으면 다음으로 이동
    }

    public static int isPalindrome(String str) {
        recursionCount = 0;
        return recursion(str, 0, str.length()-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        String[] stringArr = new String[T];

        // 각 테스트 케이스의 문자열을 배열에 저장
        for (int i = 0; i < T; i++) {
            stringArr[i] = br.readLine(); // 문자열 입력
        }

        // 팰린드롬 여부 확인 후 결과 출력
        for (String str : stringArr) {
            System.out.println(isPalindrome(str) + " " + recursionCount);
        }
    }
}
