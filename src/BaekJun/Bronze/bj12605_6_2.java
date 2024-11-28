package BaekJun.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
[ 백준 12605번 단어순서 뒤집기 ]
문제 설명 : 스페이스로 띄어쓰기 된 단어들의 리스트가 주어질 때, 단어들을 반대 순서로 뒤집어라.
          각 라인은 w개의 영단어로 이루어져 있으며, 총 L개의 알파벳을
입력 : 첫 행은 N이며, 전체 케이스의 개수이다.
      N개의 케이스들이 이어지는데, 각 케이스는 스페이스로 띄어진 단어들이다.
      스페이스는 라인의 처음과 끝에는 나타나지 않는다. (N = 5, 1 <= L <= 25)
출력 : 각 케이스에 대해서, 케이스 번호가 x일 때,
      "Case #x: "를 출력한 후 그 후에 이어서 단어를 반대 순서로 출력한다.
문제 분석
    1. 첫 행을 수로 받아 for문을 돌린다.
    2. StringTokenizer을 써서 단어들을 " "로 나눠서 스택에 넣는다.
    3. 스택에서 하나씩 거꾸로 꺼내 StringBuilder를 통해 출력한다.
결과 : [ 14004KB / 92ms ]
 */
public class bj12605_6_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); // 단어를 분리
            Stack<String> stack = new Stack<>();

            while (st.hasMoreTokens()) {
                stack.push(st.nextToken()); // 스택에 단어 저장
            }

            // 출력 형식: "Case #x: "
            sb.append("Case #").append(i + 1).append(": ");

            // 단어를 스택에 넣음
            while (!stack.isEmpty()) {
                sb.append(stack.pop()).append(" ");
                if (!stack.isEmpty()) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
