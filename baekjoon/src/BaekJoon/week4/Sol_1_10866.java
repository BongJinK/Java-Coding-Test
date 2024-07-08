package BaekJoon.week4;

import java.io.*;
import java.util.*;

public class Sol_1_10866 {
    /**
     * 문제 : 덱
     * 정수를 저장하는 덱(Deque)를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
     *
     * 명령은 총 여덟 가지이다.
     *
     * push_front X: 정수 X를 덱의 앞에 넣는다.
     * push_back X: 정수 X를 덱의 뒤에 넣는다.
     * pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다.
     *            만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
     * pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다.
     *            만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
     * size: 덱에 들어있는 정수의 개수를 출력한다.
     * empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
     * front: 덱의 가장 앞에 있는 정수를 출력한다.
     *        만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
     * back: 덱의 가장 뒤에 있는 정수를 출력한다.
     *        만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
     *
     * 입력
     * 첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다.
     * 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다.
     * 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다.
     * 문제에 나와있지 않은 명령이 주어지는 경우는 없다.
     *
     * 출력
     * 출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer line = new StringTokenizer(br.readLine().trim());
            String commend = line.nextToken();

            if (commend.equals("push_front")) {
                deque.offerFirst(Integer.parseInt(line.nextToken()));
            } else if (commend.equals("push_back")) {
                deque.offerLast(Integer.parseInt(line.nextToken()));
            } else if (commend.equals("pop_front")) {
                if (deque.isEmpty()) System.out.println(-1);
                else System.out.println(deque.pollFirst());
            } else if (commend.equals("pop_back")) {
                if (deque.isEmpty()) System.out.println(-1);
                else System.out.println(deque.pollLast());
            } else if (commend.equals("size")) {
                System.out.println(deque.size());
            } else if (commend.equals("empty")) {
                if (deque.isEmpty()) System.out.println(1);
                else System.out.println(0);
            } else if (commend.equals("front")) {
                if (deque.isEmpty()) System.out.println(-1);
                else System.out.println(deque.peekFirst());
            } else if (commend.equals("back")) {
                if (deque.isEmpty()) System.out.println(-1);
                else System.out.println(deque.peekLast());
            }
        }
        br.close();

        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer line = new StringTokenizer(br.readLine().trim(), " ");
            String commend = line.nextToken();

            switch (commend) {
                case "push_front" :
                    deque.offerFirst(Integer.parseInt(line.nextToken()));
                    break;
                case "push_back" :
                    deque.offerLast(Integer.parseInt(line.nextToken()));
                    break;
                case "pop_front" :
                    System.out.println(deque.isEmpty() ? -1 : deque.pollFirst());
                    break;
                case "pop_back" :
                    System.out.println(deque.isEmpty() ? -1 : deque.pollLast());
                    break;
                case "size" :
                    System.out.println(deque.size());
                    break;
                case "empty" :
                    System.out.println(deque.isEmpty() ? 1 : 0);
                    break;
                case "front" :
                    System.out.println(deque.isEmpty() ? -1 : deque.peekFirst());
                    break;
                case "back" :
                    System.out.println(deque.isEmpty() ? -1 : deque.peekLast());
                    break;
            }
        }
        br.close();
        */
    }
}
