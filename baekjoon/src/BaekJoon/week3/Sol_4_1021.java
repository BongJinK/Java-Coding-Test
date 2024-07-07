package BaekJoon.week3;

import java.util.*;

public class Sol_4_1021 {

    /**
     * 회전하는 큐
     *
     * 문제
     * 지민이는 N개의 원소를 포함하고 있는 양방향 순환 큐를 가지고 있다.
     * 지민이는 이 큐에서 몇 개의 원소를 뽑아내려고 한다.
     *
     * 지민이는 이 큐에서 다음과 같은 3가지 연산을 수행할 수 있다.
     *
     * 첫 번째 원소를 뽑아낸다.
     * 이 연산을 수행하면, 원래 큐의 원소가 a1, ..., ak이었던 것이 a2, ..., ak와 같이 된다.
     * 왼쪽으로 한 칸 이동시킨다.
     * 이 연산을 수행하면, a1, ..., ak가 a2, ..., ak, a1이 된다.
     * 오른쪽으로 한 칸 이동시킨다.
     * 이 연산을 수행하면, a1, ..., ak가 ak, a1, ..., ak-1이 된다.
     *
     * 큐에 처음에 포함되어 있던 수 N이 주어진다.
     * 그리고 지민이가 뽑아내려고 하는 원소의 위치가 주어진다. (이 위치는 가장 처음 큐에서의 위치이다.)
     * 이때, 그 원소를 주어진 순서대로 뽑아내는데 드는 2번, 3번 연산의 최솟값을 출력하는 프로그램을 작성하시오.
     *
     * 입력
     * 첫째 줄에 큐의 크기 N과 뽑아내려고 하는 수의 개수 M이 주어진다.
     * N은 50보다 작거나 같은 자연수이고, M은 N보다 작거나 같은 자연수이다.
     *
     * 둘째 줄에는 지민이가 뽑아내려고 하는 수의 위치가 순서대로 주어진다.
     * 위치는 1보다 크거나 같고, N보다 작거나 같은 자연수이다.
     *
     * 출력
     * 첫째 줄에 문제의 정답을 출력한다.
     *
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();

        int length = Integer.parseInt(sc.next());
        int count = Integer.parseInt(sc.next()); sc.nextLine();

        for (int i = 1; i <= length; i++) {
            deque.offerLast(i);
        }
        int result = 0;
        while (count != 0) {
            int getNumber = Integer.parseInt(sc.next());

            if (!deque.isEmpty()) {
                if (deque.peekFirst() == getNumber) {
                    deque.pollFirst();
                } else {
                    // poll 해야할 번호의 index [0번부터 시작]
                    int index = indexOf(deque, getNumber);
                    if (index == -1) break;

                    if (index <= (deque.size()/2)) {
                        // 왼쪽으로 이동
                        while (index != 0) {
                            deque.offerLast(deque.pollFirst());
                            index--;
                            result++;
                        }
                        deque.pollFirst();
                    } else {
                        // 오른쪽으로 이동
                        while (index != deque.size()) {
                            deque.offerFirst(deque.pollLast());
                            index++;
                            result++;
                        }
                        deque.pollFirst();
                    }
                }
                count--;
            } else {
                break;
            }
        }
        sc.nextLine();

        System.out.println(result);
        sc.close();
    }

    // T : 제네릭 유연한 대처
    public static <T> int indexOf(Deque<T> deque, T value) {
        int index = 0;
        for (T item : deque) {
            if (item.equals(value)) {
                return index;
            } else {
                index++;
            }
        }
        return -1;
    }
}
