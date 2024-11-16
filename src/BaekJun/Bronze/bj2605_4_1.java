package BaekJun.Bronze;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * [ 백준 2605번 줄 세우기 ]
 * - 문제 설명
 *      1. N명의 학생이 줄을 서서 번호를 뽑고, 각자가 뽑은 번호만큼 앞으로 이동해 최종적으로 줄을 선다.
 *      2. 첫 번째 학생은 무조건 0번 번호를 뽑아 제일 앞에 선다.
 *      3. 두 번째 학생부터는 자신이 뽑은 번호만큼 앞자리로 이동한다.
 *      4. 모든 학생이 자신의 번호만큼 이동한 후, 최종적으로 줄을 선 순서를 구한다.
 * - 입력
 *      1. 첫째 줄 : 학생의 수 N
 *      2. 둘째 줄 : 각 학생이 뽑은 번호 (0 <= 번호 < 학생의 현재 위치)
 * - 결과 : [ 14224KB / 104ms ]
 */
public class bj2605_4_1 {
    public static void main(String[] args) throws IOException {
        // try-with-resources 구문 사용하여 리소스 관리
        // BufferedReader 와 BufferedWriter 를 자동으로 닫아준다. (명시적으로 close() 해줄 필요없다.)
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ){
            // 학생의 수 N
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            /* LinkedList 의 각 요소는 이전 요소와 다음 요소에 대한 포인터(참조)를 가진다.
               특정 위치에 삽입할 때 해당 위치를 탐색한 후 포인터만 변경하면 되므로
               값 자체 이동할 필요가 없어 삽입 연산에 효율적이다.
               반면, ArrayList 는 배열 기반이기 때문에 중간 삽입 시 데이터 이동이 발생하여 비효율적이다.*/

            // 학생 순서를 저장할 리스트
            LinkedList<Integer> seat = new LinkedList<>();

            for(int i = 0; i < N; i++){
                int pick = Integer.parseInt(st.nextToken());
                // 현재 끝 위치에서 뽑은 번호만큼 앞으로 이동한 '위치' 계산
                seat.add(seat.size() - pick, i + 1);
            }

            // 결과 출력
            for (Integer student : seat) {
                bw.write(student + " ");
            }
            bw.flush();
        }
    }
}