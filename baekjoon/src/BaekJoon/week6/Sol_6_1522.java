package BaekJoon.week6;

import java.io.*;

public class Sol_6_1522 {
    /**
     * 문제
     * a와 b로만 이루어진 문자열이 주어질 때,
     * a를 모두 연속으로 만들기 위해서 필요한 교환의 회수를 최소로 하는 프로그램을 작성하시오.
     *
     * 이 문자열은 원형이기 때문에, 처음과 끝은 서로 인접해 있는 것이다.
     * 예를 들어,  aabbaaabaaba이 주어졌을 때, 2번의 교환이면 a를 모두 연속으로 만들 수 있다.
     *
     * 입력
     * 첫째 줄에 문자열이 주어진다. 문자열의 길이는 최대 1,000이다.
     *
     * 출력
     * 첫째 줄에 필요한 교환의 회수의 최솟값을 출력한다.
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        br.close();

        int n = 0;
        // 해당 문자열에서 a의 갯수
        for (char c : line.toCharArray()) {
            if (c == 'a') n++;
        }
        // a가 만약 0개라면 교환횟수 0
        if (n == 0) {
            System.out.println(0);
            return;
        }
        // 처음과 끝이 서로 인접해 있으므로 해당 문자열을 이어 붙인다.
        line = line + line;
        int aCnt = 0;       // 부분집합의 a개수
        int maxCnt = 0;     // 부분집합이 가지는 최대 a개수

        for (int i = 0; i <= n-1; i++) {
            // 0 ~ n-1 까지의 a의 개수
            if (line.charAt(i) == 'a') aCnt++;
        }

        for (int i = n; i < line.length(); i++) {
            // 1. 한칸씩 뒤로 슬라이드 하여 a가 나오면 aCnt 증가
            if (line.charAt(i) == 'a') aCnt++;
            // 2. 한칸씩 뒤로 밀릴때 맨앞의 값이 a라면 aCnt 감소
            if (line.charAt(i - n) == 'a') aCnt--;
            // 3. aCnt가 저장해둔 max값 보다 크다면 maxCnt 변경
            if (aCnt > maxCnt) maxCnt = aCnt;
        }
        // 연속되어야하는 a의 개수 n에서 n의 길이만큼 부분집합을 만들었을때,
        // 해당 부분집합에 포함되어 있는 최대 a의 개수를 빼면 필요한 교환 횟수의 최솟값이다.
        System.out.println(n - maxCnt);
    }
}
