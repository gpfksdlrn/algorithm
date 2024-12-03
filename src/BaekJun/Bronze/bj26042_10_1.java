package BaekJun.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * [ 백준 26042번 식당 입구 대기 줄 ]
 * 문제 설명 : 여러 학생이 학교 식당에 줄을 섬
 *          정보는 두 가지 유형으로 주어진다.
 *          1. 1 a : 학생 번호 a 가 식당 입구 맨 뒤에 줄을 선다.
 *          2. 2 : 식사 준비 완료 -> 줄 맨 앞의 학생 한명이 식사 시작
 *          모든 정보를 처리한 후, 줄 서 있는 학생 수가 최대가 되었던 순간의 학생 수와
 *          그 순간 줄 맨 뒤 학생 번호를 출력
 *          최대 학생 수가 동일한 경우, 맨 뒤 학생 번호가 가장 작은 경우 출력
 * 문제 분석 : 정보 수(n) 입력
 *           정보 수만큼 정보 입력
 *           유형이 1이면 대기줄에 추가되므로 size 확인해 대기하는 학생 수 최대인지 확인
 *           -> 최대 값과 같다면 학생 번호가 작은 것으로 업데이트 /
 *              최대 값보다 더 크다면 학생 수와 번호 업데이트
 *           유형이 2라면 queue.poll()
 *           - 최대가 되었던 순간의 학생 수(cnt)와 그때 맨 뒤 학생 번호(num) 출력
 * 결과 : [ 56200KB / 336ms ]
 */
public class bj26042_10_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 정보의 개수
        Queue<Integer> studentLine = new LinkedList<>(); // FIFO 구조

        int cnt = 0; // 최대가 되었던 순간의 학생 수
        int num = 100000; // 그때 맨 뒤 학생 번호

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");

            // 유형 1 : 학생 번호가 주어지는 경우 (줄에 새로 추가)
            if (input[0].equals("1")) {
                // 학생 번호 a가 줄을 선다.
                int a = Integer.parseInt(input[1]);
                studentLine.offer(a);

                // 대기열 크기가 최대인지 확인
                if (studentLine.size() > cnt) {
                    cnt = studentLine.size(); // 최대 크기 갱신
                    num = a; // 이때 맨 뒤의 학생 번호 갱신
                } else if (studentLine.size() == cnt) num = Math.min(num, a);

            // 유형 2 : 식사가 준비된 경우 (줄 맨 앞 학생 제거)
            } else studentLine.poll();

        }

        // 결과 출력
        System.out.println(cnt + " " + num);
    }
}
