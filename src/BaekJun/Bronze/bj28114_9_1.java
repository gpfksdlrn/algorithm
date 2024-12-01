package BaekJun.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * [ 백준 28114번 팀명 정하기 ]
 * 문제 설명 : 방법 1. 세 참가자의 입학 연도를 100으로 나눈 나머지를 오름차순으로 정렬해서 이어 붙인 문자열
 *           방법 2. 문제 해결 개수 기준 정렬 후 성씨 첫 글자 추출하여 나열한 문자열을 출력
 * 입력 : 첫째 줄에 팀원이 해결한 문제의 개수 P, 입학연도 Y, 성씨 S이 공백으로 구분되어 주어진다.
 *       둘째 줄과 셋째 줄에는 두 번째 팀원, 세 번째 팀원의 정보 P, Y, S가 주어진다.
 * 출력 : 첫째 줄에 첫 번째 방법으로 만든 팀명을 출력
 *       둘째 줄에 두 번째 방법으로 만든 팀명을 출력
 * 문제 분석 : 1. 팀명을 정하는데 방법이 두 가지가 있고, 그 결과를 출력한다.
 *           2. 리스트와 맵을 사용해 저장
 *           3. 첫 번째 방법은 연도 Y를 기준으로 100 으로 나눈 나머지를 오름차순으로 정렬해서 이어 붙인다.
 *           4. 두 번째 방법은 해결한 문제가 많은 사람부터 차례대로 영문 이름의 첫 글자를 나열한 문자열을 출력한다.
 * 결과 : [ 18312KB / 184ms ]
 */
public class bj28114_9_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<TeamMember> teamMembers = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            String[] info = br.readLine().split(" ");

            // 팀원이 해결한 문제의 개수 P, 입학연도 Y, 성씨 S
            int P = Integer.parseInt(info[0]);
            int Y = Integer.parseInt(info[1]) % 100;
            char S = info[2].charAt(0);

            // 각 팀의 정보를 Map에 저장
            teamMembers.add(new TeamMember(P, Y, S));
        }

        // 첫 번째 방법 : 입학 연도 나머지 정렬 후 문자열 생성
        String firstMethod = getFirstMethod(teamMembers);

        // 두 번째 방법 : 문제 해결 개수 기준 정렬 후 성씨 첫 글자 추출
        String secondMethod = getSecondMethod(teamMembers);

        sb.append(firstMethod).append("\n");
        sb.append(secondMethod);

        System.out.println(sb);
    }

    // 첫 번째 방법 : 입학 연도 나머지 정렬 후 문자열 생성
    private static String getFirstMethod(List<TeamMember> teamMembers) {
        List<Integer> years = new ArrayList<>();
        for (TeamMember member : teamMembers) {
            years.add(member.Y);
        }
        Collections.sort(years);

        StringBuilder result = new StringBuilder();
        for (Integer year : years) {
            result.append(year);
        }
        return result.toString();
    }

    // 두 번째 방법 : 문제 해결 개수 기준 정렬 후 성씨 첫 글자 추출
    private static String getSecondMethod(List<TeamMember> teamMembers) {
        teamMembers.sort((a, b) -> Integer.compare(b.P, a.P)); // 내림차순 정렬

        StringBuilder result = new StringBuilder();
        for (TeamMember member : teamMembers) {
            result.append(member.S);
        }
        return result.toString();
    }

    public static class TeamMember {
        int P;
        int Y;
        char S;

        public TeamMember(int P, int Y, char S) {
            this.P = P;
            this.Y = Y;
            this.S = S;
        }
    }
}
