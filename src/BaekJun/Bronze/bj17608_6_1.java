package BaekJun.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
[ 백준 17608번 막대기 ]
문제 설명 : N개의 막대기에 대한 높이 정보가 주어질 때,
         오른쪽에서 보아서 몇 개가 보이는지를 알아내는 프로그램을 작성하려고 한다.
입력 : 첫 번째 줄에는 막대기의 개수를 나타내는 정수 N(2 <= N <= 100,000)이 주어지고
      이어지는 N줄 각각에는 막대기의 높이를 나타내는 정수 h(1 <= h <= 100,000)가 주어진다.
출력 : 오른쪽에서 N개의 막대기를 보았을 때, 보이는 막대기의 개수를 출력한다.
문제 분석 : 1. 입력 받은 숫자를 스택에 쌓는다.
          2. 제일 나중의 숫자를 하나씩 빼면서 비교를 해서 크면 카운트를 한다.
결과 : [ 25912KB / 252ms ]
 */
public class bj17608_6_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int count = Integer.parseInt(br.readLine());
        int result = 0; // 막대기의 개수

        // 입력받은 높이를 스택에 쌓음
        for (int i = 0; i < count; i++) {
            stack.push(Integer.parseInt(br.readLine()));
        }

        // 스택에서 오른쪽부터 확인
        int maxHeight = 0; // 현재까지의 최대 높이
        while (!stack.isEmpty()) {
            int currentHeight = stack.pop();
            if (currentHeight > maxHeight) {
                maxHeight = currentHeight; // 최대 높이 바꿔줌
                result++; // 현재 막대기가 보임
            }
        }
        br.close();
        System.out.println(result);
    }
}
