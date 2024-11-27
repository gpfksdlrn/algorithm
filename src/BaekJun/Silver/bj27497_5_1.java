package BaekJun.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/* [ 백준 27497번 알파벳 블록 ]
문제 설명 : 알파벳 블록을 일렬로 조립하여 문자열을 만드는 게임을 만들었다.
          각 블록에는 문자 하나가 적혀 있으며 게임에는 각각 다음 기능을 수행하는 세 개의 버튼이 있다.
          - 버튼 1: 문자열 맨 뒤에 블록 추가
          - 버튼 2: 문자열 맨 앞에 블록 추가
          - 버튼 3: 문자열을 구성하는 블록 중 가장 나중에 추가된 블록 제거
          게임은 처음에 빈 문자열로 시작하며 빈 문자열일 때 문자열을 구성하는 블록 중
          가장 나중에 추가된 블록을 제거하는 버튼을 누를 경우 아무런 동작을 하지 않는다.
          버튼을 누른 횟수와 누른 버튼이 순서대로 주어질 때 완성된 문자열을 구하여라.
입력 : 첫째 줄에 버튼을 누른 횟수 N이 주어진다.
출력 : 완성된 문자열을 출력한다. 완성된 문자열이 빈 문자열인 경우 0을 출력한다.
결과 : [ 234124KB / 644ms ]
 */
public class bj27497_5_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Character> deque = new ArrayDeque<>();
        Deque<Boolean> lastAdded = new ArrayDeque<>(); // 덱 방향 기록

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            switch (num) {
                case 1: // 뒤에 추가
                    char ch1 = st.nextToken().charAt(0);
                    deque.addLast(ch1);
                    lastAdded.push(false);
                    break;
                case 2: // 앞에 추가
                    char ch2 = st.nextToken().charAt(0);
                    deque.addFirst(ch2);
                    lastAdded.push(true);
                    break;
                case 3:
                    if(!deque.isEmpty()) {
                        if(lastAdded.pop()) { // true : 2(앞), false: 1(뒤)
                            deque.removeFirst();
                        } else {
                            deque.removeLast();
                        }
                    }
                    break;
            }
        }

        if (deque.isEmpty()) {
            System.out.println(0);
        } else {
            for (char c : deque) {
                sb.append(c);
            }
            System.out.println(sb);
        }
    }
}
