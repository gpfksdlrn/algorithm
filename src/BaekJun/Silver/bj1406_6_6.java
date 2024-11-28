package BaekJun.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/** [ 백준 1406번 에디터 ]
 * 문제 설명 : 최대 600,000글자까지 입력 가능한 간단한 에디터를 구현한다.
 *           에디터에는 커서가 있으며, 초기에는 문장의 맨 뒤에 위치한다. 다음 명령어를 수행할 수 있다.
 *           - L : 커서를 왼쪽으로 한 칸 옮김(맨 앞이면 무시)
 *           - D : 커서를 오른쪽으로 한 칸 옮김(맨 뒤이면 무시)
 *           - B : 커서 왼쪽 문자를 삭제(맨 앞이면 무시)
 *           - P $ : 커서 왼쪽에 문자 $ 추가
 *           초기 문자열과 명령어 목록이 주어질 때, 모든 명령어를 수행한 후 최종 문자열을 출력한다.
 * 입력 : 첫째 줄에는 초기문자열, 둘째 줄에는 입력할 명령어의 개수 M, 셋째 줄부터 M개의 명령어들
 * 출력 : 모든 명령어 수행한 후 편집기에 입력되어 있는 문자열을 출력한다.
 * 문제 분석 : 1. 초기 문자열을 입력 받는다.
 *           2. 처음 커서의 위치는 초기 문자열의 개수 + 1이다.
 *           3. 명령어를 하나씩 처리하며, 커서의 위치와 문자열의 상태를 업데이트한다.
 *           4. 명령어 처리 시, 문자열의 앞뒤 접근이 잦으므로, 스택 두 개를 활용한다.
 *              - 왼쪽 스택 : 커서 왼쪽에 있는 문자들
 *              - 오른쪽 스택 : 커서 오른쪽에 있는 문자들
 *           5. 모든 명령어를 처리한 후, 왼쪽 스택과 오른쪽 스택을 합쳐 최종 문자열을 출력한다.
 * 결과 : [ 74220KB / 472ms ]
 */
public class bj1406_6_6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();
        String str = br.readLine();

        for (char c : str.toCharArray()) {
            leftStack.push(c);
        }

        // 명령어 개수
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String command = br.readLine();

            if (command.charAt(0) == 'L') {
                if (!leftStack.isEmpty()) {
                    rightStack.push(leftStack.pop());
                }
            } else if (command.charAt(0) == 'D') {
                if (!rightStack.isEmpty()) {
                    leftStack.push(rightStack.pop());
                }
            } else if (command.charAt(0) == 'B') {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                }
            } else if (command.charAt(0) == 'P') {
                char addChar = command.charAt(2);
                leftStack.push(addChar);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }
        while (!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }
        System.out.println(sb);
    }
}