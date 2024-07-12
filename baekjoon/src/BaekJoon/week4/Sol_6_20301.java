package BaekJoon.week4;

import java.util.*;

public class Sol_6_20301 {
    /**
     * 반전 요세푸스
     *
     * 요세푸스 문제는 다음과 같다.
     * 1번 사람 오른쪽에는 2번 사람이 앉아 있고,
     * 2번 사람 오른쪽에는 3번 사람이 앉아 있고,
     * 계속하여 같은 방식으로 N명의 사람들이 원을 이루며 앉아 있다.
     * N번 사람 오른쪽에는 1번 사람이 앉아 있다.
     * 이제 K(<= N)번 사람을 우선 제거하고, 이후 직전 제거된 사람의 오른쪽의 K번째 사람을 계속 제거해 나간다.
     * 모든 사람이 제거되었을 때, 제거된 사람의 순서는 어떻게 될까?
     *
     * 이 문제의 답을 (N, K)- 요세푸스 순열이라고 하며, (7, 3) 요세푸스 순열은 (3, 6, 2, 7, 5, 1, 4)가 된다.
     * 하지만 한 방향으로만 계속 돌아가는 건 너무 지루하다.
     * 따라서 요세푸스 문제에 재미를 더하기 위해 M명의 사람이 제거될 때마다 원을 돌리는 방향을 계속해서 바꾸려고 한다.
     * 이렇게 정의된 새로운 문제의 답을 (N, K, M)- 반전 요세푸스 순열이라고 하며,
     * (7, 3, 4)- 반전 요세푸스 순열은 (3, 6, 2, 7, 1, 5, 4)가 된다.
     *
     * N, K, M 이 주어질 때, (N, K, M)- 반전 요세푸스 순열을 계산해 보자.
     *
     * 입력
     * 첫째 줄에 정수 N, K, M이 주어진다. (1 <= N <= 5000, 1 <= K, M <= N)
     *
     * 출력
     * (N, K, M)–반전 요세푸스 순열을 이루는 수들을 한 줄에 하나씩 순서대로 출력한다.
     *
     * 7 3 4
     * > RESULT
     * 3
     * 6
     * 2
     * 7
     * 1
     * 5
     * 4
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        int k = Integer.parseInt(sc.next());
        int m = Integer.parseInt(sc.next());
        sc.nextLine();

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            deque.offerLast(i);
        }

        // true : 정방향, false : 역방향
        boolean direction = true;
        final int CONSTANT = m;
        while (!deque.isEmpty()) {
            if (direction) {
                for (int i = 1; i < k; i++) {
                    deque.offerLast(deque.pollFirst());
                }
                System.out.println(deque.pollFirst());
                m--;
            } else {
                for (int i = 1; i < k; i++) {
                    deque.offerFirst(deque.pollLast());
                }
                System.out.println(deque.pollLast());
                m--;
            }

            if (m == 0) {
                m = CONSTANT;
                direction = !direction;
            }
        }
    }
}
