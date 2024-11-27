package BaekJun.Silver;

import java.io.*;
import java.util.Stack;

/*
[ 백준 3986번 좋은 단어 ]
문제 설명 : 단어는 A와 B로만 이루어져있고, "좋은 단어"에 조건에 만족해야한다.
          좋은 단어는 1) 같은 글자(A는 A끼리, B는 B끼리)가 정확히 한 번씩 짝을 지을 수 있어야 한다.
                   2) 짝을 지으면서 선을 교차하지 않아야 한다.
입력 : 첫째 줄에 단어의 수 N이 주어진다. (1 <= N <= 100)
      다음 N개 줄에서 A와 B로만 이러우진 단어가 한 줄에 하나씩 주어진다.
출력 : 좋은 단어의 수를 출력한다.
결과 : [ 23032KB / 272ms ]
 */
public class bj3986_5_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine()); // 단어의 수
        int result = 0; // 좋은 단어의 수 초기화
        for (int i = 0; i < num; i++) {
            String str = br.readLine();
            if (isGoodWord(str)) result++;
        }
        System.out.println(result);
    }

    private static boolean isGoodWord(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) stack.pop();
            else stack.push(c);
        }
        return stack.isEmpty();
    }
}