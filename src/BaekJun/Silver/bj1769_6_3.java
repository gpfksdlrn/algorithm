package BaekJun.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
문자열 입력을 받고
변환 횟수를 출력하는 변수 = count
더한 값을 변수 = sum
문자열의 갯수가 1보다 클때까지 반복문을 돌고
반복문 안에서 향상된 포문에서 character형으로 가져와서

향상된 for문에서 character형으로 반복문을 돌고,
숫자로 변환시키면서 sum에 계속 더해줌
sum을 문자열로 형변환을 시켜준다. + count++;
while문이 끝나면 그 문자를 숫자로 바꿔줘야한다.
count 먼저 출력 \n
그 숫자가 3의 배수인지 아닌지 "YES" or "NO" 삼항연산자

	22036	228

 */
public class bj1769_6_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int count = 0;

        while(str.length() > 1){
            int sum = 0;
            for (char c : str.toCharArray()) {
                sum += c - '0'; // 아스키코드를 통해 숫자 계산이 가능
                                // Character.getNumericValue(c) 이거에 대한 활용법

            }
            str = Integer.toString(sum);
            count++;
        }
        String result = Integer.parseInt(str) % 3 == 0 ? "YES" : "NO";

        System.out.println(count);
        System.out.println(result);
    }
}
