package BaekJun.Bronze;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * [ 백준 29701번 모스 부호 ]
 * - 문제 설명
 *      1. 모스 부호는 짧은 신호와 긴 신호를 적절히 조합하여 문자 기호를 표기하는 방식이다.
 *      2. 짧은 신호를 '.', 긴 신호를 '-'로 나타낸다면, 모스 부호로 알파벳 'A'는 '.-', 숫자 1은 '.----'와 같이 표기할 수 있다.
 *      3. 알파벳 A-Z, 숫자 0-9, 기호 ',', '.', '?', ':', '-', '@'로 이루어진 길이 N인 문자열을
 *         변환한 모스 부호가 주어질 때, 주어진 모스 부호를 해독하여 원래의 문자열을 출력하는 프로그램을 작성하시오.
 * - 입력
 *      1. 첫째 줄에 모스 부호로 변환하기 전 문자열의 길이를 나타내는 정수가 주어진다.
 *      2. 둘째 줄에 원래의 문자열을 모스 부호로 변환한 메시지가 주어진다.
 *      3. 원래의 문자열을 구성하는 각각의 문자를 모스부호로 변환한 결과는 공백으로 구분되어 있다.
 * - 출력
 *      1. 주어진 모스부호를 해독하여 길이 N인 문자열을 공백 없이 출력한다.
 *      2. 알파벳의 경우, 반드시 대문자로 출력한다.
 * - 문제 분석
 *      1. Map 을 활용해 Key(모스부호)-Value(문자)로 정의
 *      2. 주어진 모스 부호를 해독하여 원래 문자열을 복원한다.
 * - 결과 : [ 14120KB / 104ms ]
 */
public class bj29701_4_2 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            HashMap<String, String> map = decodingMorseCode();

            // 첫째 줄은 문자열의 길이 정보가 주어지지만,
            // hasMoreTokens()를 활용해서 사용하지 않으므로 읽기만 하고 무시
            br.readLine();

            // 둘째 줄은 모스 부호가 공백으로 구분된 문자열로 입력 받는다.
            String morseCode = br.readLine();

            // 공백을 기준으로 모스 부호 분리
            StringTokenizer st = new StringTokenizer(morseCode, " ");
            StringBuilder sb = new StringBuilder();

            // 각 모스 부호를 해독하여 결과에 추가
            while (st.hasMoreTokens()) {
                // 하나의 문자
                String word = st.nextToken();
                sb.append(map.get(word));
            }
            bw.write(sb.toString());
            bw.flush();
        }
    }

    /**
     * 이 맵은 모스 부호를 해독할 때 사용
     */
    private static HashMap<String, String> decodingMorseCode() {
        HashMap<String, String> map = new HashMap<>();
        map.put(".-", "A");
        map.put("-...", "B");
        map.put("-.-.", "C");
        map.put("-..", "D");
        map.put(".", "E");
        map.put("..-.", "F");
        map.put("--.", "G");
        map.put("....", "H");
        map.put("..", "I");
        map.put(".---", "J");
        map.put("-.-", "K");
        map.put(".-..", "L");
        map.put("--", "M");
        map.put("-.", "N");
        map.put("---", "O");
        map.put(".--.", "P");
        map.put("--.-", "Q");
        map.put(".-.", "R");
        map.put("...", "S");
        map.put("-", "T");
        map.put("..-", "U");
        map.put("...-", "V");
        map.put(".--", "W");
        map.put("-..-", "X");
        map.put("-.--", "Y");
        map.put("--..", "Z");
        map.put(".----", "1");
        map.put("..---", "2");
        map.put("...--", "3");
        map.put("....-", "4");
        map.put(".....", "5");
        map.put("-....", "6");
        map.put("--...", "7");
        map.put("---..", "8");
        map.put("----.", "9");
        map.put("-----", "0");
        map.put("--..--", ",");
        map.put(".-.-.-", ".");
        map.put("..--..", "?");
        map.put("---...", ":");
        map.put("-....-", "-");
        map.put(".--.-.", "@");
        return map;
    }
}
