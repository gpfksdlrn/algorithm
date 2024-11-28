package BaekJun.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* [ 백준 10845번 큐 ]
문제 설명 : 정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
        - 명령은 총 6가지이다.
        - push X: 정수 X를 큐에 넣는 연산이다.
        - pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력
               만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        - size: 큐에 들어있는 정수의 개수를 출력한다.
        - empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
        - front: 큐의 가장 앞에 있는 정수를 출력한다.
                 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        - back: 큐의 가장 뒤에 있는 정수를 출력한다.
                만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
문제 분석 : 1. 명령의 수 N을 받는다.
          2. 큐를 생성한다.
          3. 명령어에 맞는 Switch 문을 사용하여 로직 구현
결과 : [ 18712KB / 156ms ]
 */
public class bj10845_6_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<String> queue = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        String lastEle = null;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push":
                    lastEle = st.nextToken();
                    queue.offer(lastEle);
                    break;
                case "pop":
                    sb.append(queue.isEmpty()? -1 : queue.poll()).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    sb.append(queue.isEmpty()? 1 : 0).append("\n");
                    break;
                case "front":
                    sb.append(queue.isEmpty()? -1 : queue.peek()).append("\n");
                    break;
                case "back":
                    sb.append(queue.isEmpty()? -1 : lastEle).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}
