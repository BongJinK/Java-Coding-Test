package BaekJoon.week4;

import java.io.*;
import java.util.*;

public class Sol_2_2346 {
    /**
     * 문제 : 풍선 터뜨리기
     * 1번부터 N번까지 N개의 풍선이 원형으로 놓여 있다.
     * i번 풍선의 오른쪽에는 i+1번 풍선이 있고, 왼쪽에는 i-1번 풍선이 있다.
     * 단, 1번 풍선의 왼쪽에 N번 풍선이 있고, N번 풍선의 오른쪽에 1번 풍선이 있다.
     * 각 풍선 안에는 종이가 하나 들어있고, 종이에는 -N보다 크거나 같고, N보다 작거나 같은 정수가 하나 적혀있다.
     * 이 풍선들을 다음과 같은 규칙으로 터뜨린다.
     *
     * 우선, 제일 처음에는 1번 풍선을 터뜨린다.
     * 다음에는 풍선 안에 있는 종이를 꺼내어 그 종이에 적혀있는 값만큼 이동하여 다음 풍선을 터뜨린다.
     * 양수가 적혀 있을 경우에는 오른쪽으로, 음수가 적혀 있을 때는 왼쪽으로 이동한다.
     * 이동할 때에는 이미 터진 풍선은 빼고 이동한다.
     *
     * 예를 들어 다섯 개의 풍선 안에 차례로 3, 2, 1, -3, -1이 적혀 있었다고 하자.
     * 이 경우 3이 적혀 있는 1번 풍선, -3이 적혀 있는 4번 풍선, -1이 적혀 있는 5번 풍선,
     * 1이 적혀 있는 3번 풍선, 2가 적혀 있는 2번 풍선의 순서대로 터지게 된다.
     *
     * 입력
     * 첫째 줄에 자연수 N(1 ≤ N ≤ 1,000)이 주어진다.
     * 다음 줄에는 차례로 각 풍선 안의 종이에 적혀 있는 수가 주어진다.
     * 종이에 0은 적혀있지 않다.
     *
     * 출력
     * 첫째 줄에 터진 풍선의 번호를 차례로 나열한다
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine().trim());

        Deque<Integer> deque = new ArrayDeque<>();
        Deque<Integer> result = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for (int i = 1; i <= n; i++) {
            String value = st.nextToken();
            deque.offerLast(Integer.parseInt(value));
            result.offerLast(i);
        }

        int first = deque.pollFirst();
        sb.append(result.pollFirst() + " ");
        while (!deque.isEmpty()) {
            if (first < 0) {
                for (int i = 0; i < Math.abs(first); i++) {
                    deque.offerFirst(deque.pollLast());
                    result.offerFirst(result.pollLast());
                }
            } else {
                for (int i = 1; i < first; i++) {
                    deque.offerLast(deque.pollFirst());
                    result.offerLast(result.pollFirst());
                }
            }
            first = deque.pollFirst();
            sb.append(result.pollFirst() + " ");
        }
        System.out.println(sb);
        br.close();
    }
}
