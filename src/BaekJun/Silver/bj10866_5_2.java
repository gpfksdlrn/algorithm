package BaekJun.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/* [ 백준 10866번 덱 ]
문제 설명 : 정수를 저장하는 덱(Deque)를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
          명령은 총 여덟 가지이다.
            1. push_frontX: 정수 X를 덱의 앞에 넣는다.
            2. push_backX: 정수 X를 덱의 뒤에 넣는다.
            3. pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다.
               만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
            4. pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다.
               만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
            5. size: 덱에 들어있는 정수의 개수를 출력한다.
            6. empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
            7. front: 덱의 가장 앞에 있는 정수를 출력한다.
               만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
            8. back: 덱의 가장 뒤에 있는 정수를 출력한다.
               만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
입력 : 첫째 줄 - 명령의 수 N, 둘째 줄부터 N개의 명령이 하나씩 주어진다.
출력 : 출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.
결과 : [ 19128KB / 164ms ]

참고사항
// peekLast() : 덱이 비어 있는 경우에도 안전하게 호출할 수 있다.
// getLast() : 덱이 비어 있을 가능성이 없다면 사용하는 것이 더 직관적이다.
 */
public class bj10866_5_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<String> deque = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push_front":
                    deque.addFirst(st.nextToken());
                    break;
                case "push_back":
                    deque.addLast(st.nextToken());
                    break;
                case "pop_front":
                    sb.append(!deque.isEmpty() ? deque.removeFirst() : -1).append("\n");
                    break;
                case "pop_back":
                    sb.append(!deque.isEmpty() ? deque.removeLast() : -1).append("\n");
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    sb.append(!deque.isEmpty() ? deque.getFirst() : -1).append("\n");
                    break;
                case "back":
                    sb.append(!deque.isEmpty() ? deque.getLast() : -1).append("\n");
                    break;
            }
//            if (command.startsWith("push_front")) {
//                int X = Integer.parseInt(command.split(" ")[1]);
//                deque.addFirst(X);
//            } else if (command.startsWith("push_back")) {
//                int X = Integer.parseInt(command.split(" ")[1]);
//                deque.addLast(X);
//            } else if (command.equals("pop_front")) {
//                if(!deque.isEmpty()) {
//                    sb.append(deque.removeFirst()).append("\n");
//                } else {
//                    sb.append(-1).append("\n");
//                }
//            } else if (command.equals("pop_back")) {
//                if(!deque.isEmpty()) {
//                    sb.append(deque.removeLast()).append("\n");
//                } else {
//                    sb.append(-1).append("\n");
//                }
//            } else if (command.equals("size")) {
//                sb.append(deque.size()).append("\n");
//            } else if (command.equals("empty")) {
//                sb.append(deque.isEmpty() ? 1 : 0).append("\n");
//            } else if (command.equals("front")) {
//                if(!deque.isEmpty()) {
//                    sb.append(deque.getFirst()).append("\n");
//                } else {
//                    sb.append(-1).append("\n");
//                }
//            } else if (command.equals("back")) {
//                if(!deque.isEmpty()) {
//                    sb.append(deque.getLast()).append("\n");
//                } else {
//                    sb.append(-1).append("\n");
//                }
//            }
        }
        System.out.println(sb);
    }
}
