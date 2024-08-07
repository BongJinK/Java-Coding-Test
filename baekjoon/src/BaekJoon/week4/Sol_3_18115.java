package BaekJoon.week4;

import java.io.*;
import java.util.*;

public class Sol_3_18115 {

    /**
     * 문제 : 카드 놓기
     * 수현이는 카드 기술을 연습하고 있다.
     * 수현이의 손에 들린 카드를 하나씩 내려놓아 바닥에 쌓으려고 한다.
     * 수현이가 쓸 수 있는 기술은 다음 3가지다.
     *
     * 제일 위의 카드 1장을 바닥에 내려놓는다.
     * 위에서 두 번째 카드를 바닥에 내려놓는다. 카드가 2장 이상일 때만 쓸 수 있다.
     * 제일 밑에 있는 카드를 바닥에 내려놓는다. 카드가 2장 이상일 때만 쓸 수 있다.
     * 수현이는 처음에 카드 N장을 들고 있다.
     * 카드에는 1부터 N까지의 정수가 중복되지 않게 적혀 있다. 기술을 N번 사용하여 카드를 다 내려놓았을 때,
     * 놓여 있는 카드들을 확인했더니 위에서부터 순서대로 1, 2, …, N이 적혀 있었다!
     *
     * 놀란 수현이는 처음에 카드가 어떻게 배치되어 있었는지 궁금해졌다. 처음 카드의 상태를 출력하여라.
     *
     * 입력
     * 첫 번째 줄에는 N (1 ≤ N ≤ 106)이 주어진다.
     * 두 번째 줄에는 길이가 N인 수열 A가 주어진다.
     * Ai가 x이면, i번째로 카드를 내려놓을 때 x번 기술을 썼다는 뜻이다.
     * Ai는 1, 2, 3 중 하나이며, An은 항상 1이다.
     *
     * 출력
     * 초기 카드의 상태를 위에서부터 순서대로 출력하여라.
     *
     *
     * 5
     * 2 3 3 2 1 >> 1 5 2 3 4
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> commends = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for (int i = 1; i <= n; i++) {
            String x = st.nextToken();
            commends.offerLast(Integer.parseInt(x));
        }

        Deque<Integer> result = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            int commend = commends.pollLast();

            if (commend == 1) {
                result.offerLast(i);
            } else if (commend == 2) {
                int temp = result.pollLast();
                result.offerLast(i);
                result.offerLast(temp);
            } else if (commend == 3) {
                result.offerFirst(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!result.isEmpty()) {
            sb.append(result.pollLast() + " ");
        }
        System.out.println(sb);
        br.close();

    }

}
