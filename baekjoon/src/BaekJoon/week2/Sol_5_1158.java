package BaekJoon.week2;

import java.util.*;

public class Sol_5_1158 {
    /**
     * 요세푸스 문제
     *
     * 문제
     * 요세푸스 문제는 다음과 같다.
     *
     * 1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다.
     * 이제 순서대로 K번째 사람을 제거한다.
     * 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다.
     * 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다.
     * 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다.
     * 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.
     *
     * N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.
     *
     * 입력
     * 첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 5,000)
     *
     * 출력
     * 예제와 같이 요세푸스 순열을 출력한다.
     *
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.next());
        int removeIndex = Integer.parseInt(sc.next());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= size; i++) {
            queue.offer(i);
        }

        StringBuilder sb = new StringBuilder("<");
        while (queue.size() != 1) {
            for (int i = 1; i < removeIndex; i++) {
                queue.offer(queue.remove());
            }

            sb.append(queue.remove()).append(", ");
        }
        sb.append(queue.remove()).append(">");
        System.out.println(sb);
        sc.close();
    }

    /*

    [1] [2] [3] [4] [5] [6] [7]

    index 3 - 3
    index 5 - 6
    index 2 - 2
    index 4 - 7
    index 3 - 5
    index 1 - 1
    index 1 - 4

    ( 시작 인덱스 + 고정 인덱스 -1 ) / 배열(큐) 사이즈

    ( 1 + 3 -1 ) % 7[q.size()] => 3

    ( 3 + 3 -1 ) % 6[q.size()] => 5

    ( 5 + 3 -1 ) % 5[q.size()] => 2

    ( 2 + 3 -1 ) % 4[q.size()] => 0 -> q.size() 4

    ( 4 + 3 -1 ) % 3[q.size()] => 0 -> q.size() 3

    ( 3 + 3 -1 ) % 2[q.size()] => 1

    ( 1 + 3 - 1) % 1[q.size()] => 0 -> q.size() 1

     */

}
