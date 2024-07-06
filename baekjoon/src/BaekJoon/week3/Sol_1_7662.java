package BaekJoon.week3;

import java.util.*;


public class Sol_1_7662 {
    /**
     * 이중 우선 순위 큐
     * 이중 우선 순위 큐(dual priority queue)는 전형적인 우선순위 큐처럼 데이터를 삽입, 삭제할 수 있는 자료 구조이다.
     * 전형적인 큐와의 차이점은 데이터를 삭제할 때 연산(operation) 명령에 따라
     * 우선순위가 가장 높은 데이터 또는 가장 낮은 데이터 중 하나를 삭제하는 점이다.
     * 이중 우선순위 큐를 위해선 두 가지 연산이 사용되는데,
     *
     * 1. 데이터를 삽입하는 연산
     * 2. 데이터를 삭제하는 연산
     * 2-1. 우선순위가 가장 높은 것을 삭제하기 위한 연산
     * 2-2. 우선순위가 가장 낮은 것을 삭제하기 위한 연산
     *
     * 정수만 저장하는 이중 우선순위 큐 Q가 있다고 가정하자.
     * Q에 저장된 각 정수의 값 자체를 우선순위라고 간주하자.
     *
     * Q에 적용될 일련의 연산이 주어질 때 이를 처리한 후 최종적으로 Q에 저장된 데이터 중
     * 최댓값과 최솟값을 출력하는 프로그램을 작성하라.
     *
     * ## 입력
     * 입력 데이터는 표준입력을 사용한다. 입력은 T개의 테스트 데이터로 구성된다.
     * 입력의 첫 번째 줄에는 입력 데이터의 수를 나타내는 정수 T가 주어진다.
     * 각 테스트 데이터의 첫째 줄에는 Q에 적용할 연산의 개수를 나타내는 정수 k (k ≤ 1,000,000)가 주어진다.
     * 이어지는 k 줄 각각엔 연산을 나타내는 문자(‘D’ 또는 ‘I’)와 정수 n이 주어진다.
     * ‘I n’은 정수 n을 Q에 삽입하는 연산을 의미한다. (동일한 정수가 삽입될 수 있음)
     * ‘D 1’는 Q에서 최댓값을 삭제하는 연산을 의미하며,
     * ‘D -1’는 Q 에서 최솟값을 삭제하는 연산을 의미한다.
     * 최댓값(최솟값)을 삭제하는 연산에서 최댓값(최솟값)이 둘 이상인 경우, 하나만 삭제됨을 유념하기 바란다.
     *
     * 만약 Q가 비어있는데 적용할 연산이 ‘D’라면 이 연산은 무시해도 좋다.
     * Q에 저장될 모든 정수는 -2^31 이상 2^31 미만인 정수이다.
     *
     * */
    public static void main(String[] args) {
        // TreeMap : 정렬된 맵 [오름차순으로 정렬]
        // Map : Key - value 쌍으로 저장
        // put, get, remove, firstKey, lastKey, getOrDefault
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < t; x++) {
            int k = Integer.parseInt(sc.nextLine());

            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < k; i++) {
                String commend = sc.next();
                int number = Integer.parseInt(sc.next());
                sc.nextLine();

                if (commend.equals("I")) {
                    map.put(number, map.getOrDefault(number, 0) + 1);
                } else {
                    if (map.isEmpty()) continue;

                    if (number == 1) {
                        int maxKey = map.lastKey();
                        if (map.get(maxKey) == 1) {
                            map.remove(maxKey);
                        } else {
                            map.put(maxKey, map.get(maxKey) - 1);
                        }
                    } else {
                        int minKey = map.firstKey();
                        if (map.get(minKey) == 1) {
                            map.remove(minKey);
                        } else {
                            map.put(minKey, map.get(minKey) - 1);
                        }

                    }
                }
            }
            if (map.isEmpty()) sb.append("EMPTY\n");
            else sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
        }

        System.out.println(sb);
        sc.close();
    }


    /* PriorityQueue X, TreeMap X
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int dataRepeat = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();

        for (int x = 0; x < dataRepeat; x++) {
            int repeat = Integer.parseInt(sc.nextLine());
            Queue<Integer> q = new LinkedList<>();

            int max = -2147483648;
            int min = 2147483647;

            for (int i = 1; i <= repeat; i++) {
                char commend = sc.next().charAt(0);
                int number = Integer.parseInt(sc.next());

                switch(commend) {
                    case 'I' :
                        if (number > max) max = number;
                        if (number < min) min = number;
                        q.offer(number);
                        break;
                    case 'D' :
                        if (q.isEmpty()) {
                            max = -2147483648;
                            min = 2147483647;
                            break;
                        }

                        if (number == 1) {
                            q.remove(max);
                            int temp = min;
                            for (Integer value : q) {
                                if (value >= temp) temp = value;
                            }
                            max = temp;
                        } else if (number == -1) {
                            q.remove(min);
                            int temp = max;
                            for (Integer value : q) {
                                if (value <= temp) temp = value;
                            }
                            min = temp;
                        }
                        break;
                }
            }

            if (q.isEmpty()) sb.append("EMPTY\n");
            else sb.append(max).append(" ").append(min);
            sc.nextLine();
        }

        System.out.println(sb);
        sc.close();


    }*/


}
