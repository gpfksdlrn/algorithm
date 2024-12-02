package BaekJun.Bronze;

import java.util.*;
import java.io.*;
/**
 * [ 백준 16466번 콘서트 ]
 * 문제 설명 : 1.	이미 1차 티켓팅에서 팔린 티켓 번호 목록이 주어진다.
 * 	         2.	1번부터 시작하는 번호 중 팔리지 않은 가장 작은 티켓 번호를 찾아 출력한다.
 * 입력 : 첫째 줄에는 티켓팅에서 팔린 티켓들의 수인 정수 N이 주어진다.
 *       둘째 줄에는 1차 티켓팅에서 팔린 티켓들의 번호 정수 A가 주어진다.
 * 출력 : 2차 티켓팅에서 양한이가 가질 수 있는 티켓 중 가장 작은 번호를 출력한다.
 * 결과 : [ 144944KB / 556ms ]
 */
public class bj16466_9_3 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄 : 팔린 티켓의 수 N
        int N = Integer.parseInt(br.readLine());

        // 입력을 받은 문자열을 배열로 만든 후 int 배열에 저장합니다.
        String[] ticketStrings = br.readLine().split(" ");
        int[] soldTickets = new int[ticketStrings.length];
        for (int i = 0; i < ticketStrings.length; i++) {
            soldTickets[i] = Integer.parseInt(ticketStrings[i]);
        }

        // 오름차순 정렬
        Arrays.sort(soldTickets);

        // 배열을 순회한다. 만약 인덱스번호 + 1과 요소의 값이 일치하지 않을 경우,
        // 그 주변에 가장 작은 번호가 있음을 예상해볼 수 있습니다.
        for (int i = 0; i < N; i++) {
            if (soldTickets[i] != i + 1) {
                System.out.println(i + 1);
                break;
                // 마지막 요소까지 도달했는데도 모든 번호가 같을 경우에는 마지막 번호의 +1한 값을 출력합니다.
            } else if (i == N - 1 && soldTickets[i] == i + 1) {
                System.out.println(i + 2);
            }
        }
        br.close();
    }
}
