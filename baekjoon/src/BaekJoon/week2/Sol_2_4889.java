package BaekJoon.week2;

import java.util.*;

public class Sol_2_4889 {
    /**
     * 여는 괄호와 닫는 괄호만으로 이루어진 문자열이 주어진다.
     * 여기서 안정적인 문자열을 만들기 위한 최소 연산의 수를 구하려고 한다.
     * 안정적인 문자열의 정의란 다음과 같다.
     *
     * 빈 문자열은 안정적이다.
     * S가 안정적이라면, {S}도 안정적인 문자열이다.
     * S와 T가 안정적이라면, ST(두 문자열의 연결)도 안정적이다.
     * {}, {}{}, {{}{}}는 안정적인 문자열이지만, }{, {{}{, {}{는 안정적인 문자열이 아니다.
     *
     * 문자열에 행할 수 있는 연산은 여는 괄호를 닫는 괄호로 바꾸거나, 닫는 괄호를 여는 괄호로 바꾸는 것 2가지이다.
     *
     * 입력
     * 입력은 여러 개의 데이터 세트로 이루어져 있다. 각 데이터 세트는 한 줄로 이루어져 있다.
     * 줄에는 여는 괄호와 닫는 괄호만으로 이루어진 문자열이 주어진다.
     * 문자열의 길이가 2000을 넘는 경우는 없고, 항상 길이는 짝수이다.
     *
     * 입력의 마지막 줄은 '-'가 한 개 이상 주어진다.
     *
     * 출력
     * 각 테스트 케이스에 대해서, 테스트 케이스 번호와 입력으로
     * 주어진 문자열을 안정적으로 바꾸는데 필요한 최소 연산의 수를 출력한다.
     *
     * 입력 1
     * }{
     * {}{}{}
     * {{{}
     * ---
     *
     * 출력 1
     * 1. 2
     * 2. 0
     * 3. 1
     *
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        int count = 0;
        int change;

        while(true) {
            String line = sc.nextLine();
            if (line.contains("-")) break;

            int n = line.length();
            Stack<Character> st = new Stack<>();
            count++;
            change = 0;

            for (int i = 0; i < n; i++) {
                char ch = line.charAt(i);

                if (ch == '{') {
                    st.push(ch);
                } else if (ch == '}') {
                    if (!st.isEmpty() && st.peek() == '{') {
                        st.pop();
                    } else if (st.isEmpty()) {
                        change++;
                        st.push('{');
                    }
                }
            }

            if (!st.isEmpty()) {
                change += st.size() / 2;
            }
            sb.append(count).append(". ").append(change).append("\n");
        }

        System.out.println(sb.toString());
        sc.close();

    }
}
