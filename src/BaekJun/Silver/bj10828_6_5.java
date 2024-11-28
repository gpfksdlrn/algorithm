package BaekJun.Silver;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/* [ 백준 10828번 스택 ]
문제 설명 : 정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
          - push X: 정수 X를 스택에 넣는 연산이다.
          - pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다.
                 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
          - size: 스택에 들어있는 정수의 개수를 출력한다.
          - empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
          - top: 스택의 가장 위에 있는 정수를 출력한다.
                 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
문제 분석 : 1. 명령의 수 N을 받는다.
          2. 스택을 생성한다.
          3. 명령어에 맞는 Switch 문을 사용하여 로직 구현
결과 : [ 19676KB / 156ms ]
 */
public class bj10828_6_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(stack.empty()? -1 : stack.pop()).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    sb.append(stack.empty()? 1 : 0).append("\n");
                    break;
                case "top":
                    sb.append(stack.empty()? -1 : stack.peek()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
