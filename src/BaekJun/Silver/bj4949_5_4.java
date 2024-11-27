package BaekJun.Silver;

import java.io.*;
import java.util.Stack;

/*
[ 백준 4949번 균형잡힌 세상 ]
문제 설명 : 문자열이 주어졌을 때, 괄호들의 균형이 잘 맞춰져 있는지 판단하는 프로그램을 짜는 것
입력 : 각 문자열은 마지막 글자를 제외하고 영문 알파벳, 공백, 소괄호("()"), 대괄호("[]")로 이루어져 있으며,
      온점(".")으로 끝나고, 길이는 100글자보다 작거나 같다.
      입력의 종료조건으로 맨 마지막에 온점 하나(".")가 들어온다.
출력 : 각 줄마다 해당 문자열이 균형을 이루고 있으면 "yes", 아니면 "no"를 출력
문제 분석
    1. 주어진 문자열을 하나씩 읽는다. (영문 알파벳, 공백, 소괄호("()"), 대괄호("[]")로 이루어짐)
    2. 온점(".")이 나오면 더이상 입력을 받지 않고, 프로그램을 종료한다.
    3. 각 문자를 비교하면서
    4.  여는 괄호 (, [ 가 나오면 스택에 쌓는다.
    5.  닫는 괄호 ), ] 가 나오면 스택에서 여는 괄호와 짝이 맞는지 확인하고, 맞지 않으면 "no"를 출력한다.
    6. 만약 문자열 끝까지 갔을 때 스택에 여는 괄호가 남아 있으면 "no"를 출력한다.
    7. 스택이 비어 있으면 "yes"를 출력한다.
    8. 각 줄에 대해 "yes" 또는 "no"를 출력한다.
결과 : [ 19816KB / 192ms ]
 */
public class bj4949_5_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String input = br.readLine();
            if (input.equals(".")) break;

            bw.write(isBalanced(input) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
    

    private static String isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') return "no";
                stack.pop();
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') return "no";
                stack.pop();
            }
        }
        return stack.isEmpty() ? "yes" : "no";
    }
}
