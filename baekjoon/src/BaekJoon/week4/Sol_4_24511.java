package BaekJoon.week4;

import java.io.*;
import java.util.*;

public class Sol_4_24511 {

    /**
     * 문제 : queueStack
     * 한가롭게 방학에 놀고 있던 도현이는 갑자기 재밌는 자료구조를 생각해냈다.
     * 그 자료구조의 이름은 queueStack이다.
     *
     * queueStack의 구조는 다음과 같다.
     * 1번, 2번, ... , N번의 자료구조(queue 혹은 stack)가 나열되어있으며,
     * 각각의 자료구조에는 한 개의 원소가 들어있다.
     * queueStack의 작동은 다음과 같다.
     *
     * x0을 입력받는다.
     * x0을 1번 자료구조에 삽입한 뒤 1번 자료구조에서 원소를 pop한다.
     * 그때 pop된 원소를 x_1이라 한다.
     * x1을 2번 자료구조에 삽입한 뒤 2번 자료구조에서 원소를 pop한다. 그때 pop된 원소를 x2이라 한다.
     * ...
     *
     * xN-1을 N번 자료구조에 삽입한 뒤 N번 자료구조에서 원소를 pop한다.
     * 그때 pop된 원소를 x_N이라 한다.
     * xN을 리턴한다.
     * 도현이는 길이 M의 수열 C를 가져와서 수열의 원소를 앞에서부터 차례대로 queueStack에 삽입할 것이다.
     * 이전에 삽입한 결과는 남아 있다. (예제1 참고)
     *
     * queueStack에 넣을 원소들이 주어졌을 때, 해당 원소를 넣은 리턴값을 출력하는 프로그램을 작성해보자.
     *
     * 입력
     * 첫째 줄에 queueStack을 구성하는 자료구조의 개수
     * N이 주어진다. (1 <= N <= 100,000)
     *
     * 둘째 줄에 길이
     * N의 수열 A가 주어진다. i번 자료구조가 큐라면 A_i = 0, 스택이라면 A_i = 1이다.
     *
     * 셋째 줄에 길이
     * N의 수열 B가 주어진다.
     * B_i는 i번 자료구조에 들어 있는 원소이다. (1 <= B_i <= 1,000,000,000)
     *
     * 넷째 줄에 삽입할 수열의 길이
     * M이 주어진다. (1 <= M <= 100,000)
     *
     * 다섯째 줄에 queueStack에 삽입할 원소를 담고 있는
     * 길이 M의 수열 C가 주어진다. (1 <= C_i <= 1,000,000,000)
     *
     * 입력으로 주어지는 모든 수는 정수이다.
     *
     * 출력
     * 수열
     * C의 원소를 차례대로 queueStack에 삽입했을 때의 리턴값을 공백으로 구분하여 출력한다.
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine().trim());

        Deque<Integer> deque = new ArrayDeque<>();
        StringTokenizer to1 = new StringTokenizer(br.readLine());
        StringTokenizer to2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            String token = to1.nextToken();
            String token2 = to2.nextToken();
            if (token.equals("0")) {
                deque.offerLast(Integer.parseInt(token2));
            }
        }

        int k = Integer.parseInt(br.readLine().trim());
        StringTokenizer to3 = new StringTokenizer(br.readLine());

        for (int i = 0; i < k; i++) {
            if (!deque.isEmpty()) {
                bw.write(deque.pollLast() + " ");
            } else {
                bw.write(to3.nextToken() + " ");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
