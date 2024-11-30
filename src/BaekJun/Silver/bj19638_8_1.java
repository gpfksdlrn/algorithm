package BaekJun.Silver;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * [ 백준 19638번 센티와 마법의 뿅망치 ]
 * 문제 설명 : 센티는 키가 h인 악당이며, 거인들의 키가 담긴 리스트 giants 가 있다.
 *           센티는 마법의 뿅망치를 최대 k번 사용할 수 있다.
 *           뿅망치에 맞은 사람의 키가 [뿅망치 맞은 사람의 키 / 2]로 변하는 마법 도구
 *           단, 키가 1인 경우 뿅망치의 영향을 받지 않는다.
 *           센티는 뿅망치를 매번 가장 키가 큰 거인에게 사용
 *           센티가 뿅망치를 사용한 후, 거인들의 키가 모두 센티의 키 h보다 작도록 만들 수 있는지 판단하세요.
 * 입력 : 첫 번째 줄 - 센티를 제외한 거인의 나라의 인구수 N, 센티의 키를 나타내는 정수, 마법의 뿅망치의 횟수 제한 T
 *       두 번째 줄부터 N개의 줄에 각 거인의 키를 나타내는 정수 H가 주어진다.
 * 출력 :  모든 거인의 키가 센티보다 작아질 수 있으면 "YES"룰 출력하고 두 번째 줄에 뿅망치를 최소로 사용한 횟수를 출력
 * 		  작아질 수 없다면 “NO”를 출력하고, 두 번째 줄에 마법의 뿅망치 사용 이후 거인의 나라에서 키가 가장 큰 거인의 키를 출력
 * 문제 분석 : 1. 거인의 수 N, 센티의 키 H, 뿅망치 사용 가능 횟수 T를 입력 받는다.
 *           2. for문을 통해 거인들의 키를 우선순위 큐에 삽입
 *           3. 이미 모든 거인이 센티보다 작다면 바로 "NO" 처리
 *           4. while 문을 통해 마법의 뿅망치를 사용하면서 거인들의 키를 조정
 *              우선순위 큐가 비어있지 않은지, 우선순위 큐에서 가장 큰 값이 센티보다 큰지,
 *              마법의 뿅망치 사용 횟수가 T 최대 사용 횟수보다 미만일 떄만 반복문을 계속 실행한다.
 *           5. 모든 거인이 센티보다 작인지 확인
 * 결과 : [ 27548KB / 328ms ]
 */
public class bj19638_8_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int count = 0;

        for(int i=0; i<N; i++) {
            heap.add(Integer.parseInt(br.readLine()));
        }

        for(int i=0; i<T; i++) {
            if(heap.peek() == 1 || heap.peek() < H) {
                break;
            } else if(heap.peek() >= H) {
                heap.add(heap.poll() / 2);
                count++;
            }
        }

        if(heap.peek() < H) bw.write("YES\n" + count);
        else bw.write("NO\n" + heap.peek());

        br.close();

        bw.flush();

        bw.close();
    }
}
