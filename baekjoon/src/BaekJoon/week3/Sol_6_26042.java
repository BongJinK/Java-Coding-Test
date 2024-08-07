package BaekJoon.week3;

import java.io.*;
import java.util.*;

public class Sol_6_26042 {

    /**
     * 식당 입구 대기 줄
     *
     * 문제
     * 여러 명의 학생이 식사하기 위하여 학교 식당을 향해 달려가고 있다.
     * 학교 식당에 도착한 학생은 식당 입구에 줄을 서서 대기한다.
     * 학교 식당에 먼저 도착한 학생이 나중에 도착한 학생보다 식당 입구의 앞쪽에서 대기한다.
     * 식사는 1인분씩 준비된다.
     * 식사 1인분이 준비되면 식당 입구의 맨 앞에서 대기 중인 학생 1명이 식당으로 들어가서 식사를 시작한다.
     * 식사를 시작한 학생은 항상 식사를 마친다.
     *
     * 학생이 학교 식당에 도착하고 식사가 준비되는 n개의 정보가 저장된 A가 주어진다.
     * A에 저장된 첫 번째 정보부터 n번째 정보까지 순서대로 처리한 다음,
     * 식당 입구에 줄을 서서 대기하는 학생 수가 최대가 되었던 순간의 학생 수와
     * 이때 식당 입구의 맨 뒤에 대기 중인 학생의 번호를 출력하자.
     * 대기하는 학생 수가 최대인 경우가 여러 번이라면 맨 뒤에 줄 서 있는 학생의 번호가 가장 작은 경우를 출력하자.
     *
     * A에 저장된 n개의 정보는 아래 두 가지 유형으로 구분된다.
     * 첫 번째가 유형 1
     * 두 번째가 유형 2이다.
     *
     * 유형 1 a: 학생 번호가 양의 정수 a인 학생 1명이 학교 식당에 도착하여 식당 입구의 맨 뒤에 줄을 서기 시작한다.
     * 유형 2 : 식사 1인분이 준비되어 식당 입구의 맨 앞에서 대기 중인 학생 1명이 식사를 시작한다.
     * 식사 1인분이 준비될 때는 식당 입구에서 대기 중인 학생이 항상 존재한다.
     * 식당 입구에 줄을 서서 대기하였으나 식사가 준비 안 된 학생은 식사를 못 한다.
     *
     * 입력
     * 첫 번째 줄에 n이 주어진다.
     *
     * 다음 줄부터 n개의 줄에 걸쳐 한 줄에 하나의 정보가 주어진다. 주어지는 정보는 유형 1, 2중 하나이다.
     *
     * 출력
     * 첫 번째 정보부터 n번째 정보까지 순서대로 처리한 다음,
     * 식당 입구에 줄을 서서 대기하는 학생 수가 최대가 되었던 순간의 학생 수와
     * 이때 식당 입구의 맨 뒤에 대기 중인 학생의 번호를 빈칸을 사이에 두고 순서대로 출력한다.
     * 대기하는 학생 수가 최대인 경우가 여러 번이라면 맨 뒤에 줄 서 있는 학생의 번호가 가장 작은 경우를 출력한다.
     *
     * 제한
     * 1 ≤ n ≤ 100,000
     * A에는 유형 1, 유형 2만 저장되어 있다.
     * 1 ≤ a ≤ n, 모든 양의 정수 a의 값은 서로 다르다.
     *
     * */
    /**
     * 시간 제한 : 0.1초
     * Scanner 보다 BufferedReader 가 입력 더 빠르게 처리 가능
     * StringTokenizer
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        //Scanner sc = new Scanner(System.in);
        //int n = Integer.parseInt(sc.nextLine());

        int stuCount = 0;
        int lastNumber = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // 구분자 명시 하지 않을 시 Default " "
            // StringTokenizer st = new StringTokenizer(inputString, " ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            // String[] temp = sc.nextLine().split(" ");

            if (Integer.parseInt(st.nextToken()) == 1) {
                int number = Integer.parseInt(st.nextToken());

                deque.offerLast(number);
                if (stuCount < deque.size()) {
                    stuCount = deque.size();
                    lastNumber = deque.peekLast();
                } else if (stuCount == deque.size()) {
                    if (!deque.isEmpty() && lastNumber > deque.peekLast()) {
                        lastNumber = deque.peekLast();
                    }
                }
            } else {
                deque.pollFirst();
            }
        }
        System.out.println(stuCount + " " + lastNumber);

    }
}
