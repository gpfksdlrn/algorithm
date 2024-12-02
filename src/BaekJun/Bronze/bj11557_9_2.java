package BaekJun.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [ 백준 11557번 Yangjojang of The Year ]
 * 문제 설명 : 학교별로 한 해동안 술 소비량이 주어질 때, 가장 술 소비가 많은 학교 이름을 출력하세요.
 * 입력 : 입력의 첫 줄에는 테스트 케이스의 숫자 T가 주어진다.
 *       매 입력의 첫 줄에는 학교의 숫자 정수 N이 주어진다.
 *       이어서 N줄에 걸쳐 학교 이름 S(1 <= |S| <= 20, S는 공백없는 대소문자 알파벳 문자열)와
 *       해당 학교가 지난 한 해동안 소비한 술의 양 L이 공백으로 주어진다.
 * 출력 : 각 테스트 케이스마다 한 줄에 걸쳐 술 소비가 가장 많은 학교의 이름을 출력한다.
 * 결과 : [ 11352KB / 64ms ]
 */
public class bj11557_9_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        // 테스트 케이스별
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            String maxSchool = "";
            int maxConsumption = 0;

            // 학교별
            while (N-- > 0) {
                String[] str = br.readLine().split(" ");
                String school = str[0]; // 학교 이름
                int consumption = Integer.parseInt(str[1]); // 술의 양

                // 최대 소비량을 가진 학교를 업데이트
                if (consumption > maxConsumption) {
                    maxConsumption = consumption;
                    maxSchool = school;
                }
            }
            sb.append(maxSchool).append("\n");
        }
        System.out.println(sb);
    }
}