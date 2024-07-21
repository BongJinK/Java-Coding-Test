package BaekJoon.week5;

import java.util.*;
import java.io.*;

public class Sol_4_1351 {

    /**
     *
     * 무한 수열 A는 다음과 같다.
     *
     * A0 = 1
     * Ai = A⌊i/P⌋ + A⌊i/Q⌋ (i ≥ 1)
     * N, P와 Q가 주어질 때, AN을 구하는 프로그램을 작성하시오.
     *
     * 입력
     * 첫째 줄에 3개의 정수 N, P, Q가 주어진다.
     *
     * 출력
     * 첫째 줄에 AN을 출력한다.
     *
     * 제한
     * 0 ≤ N ≤ 1012
     * 2 ≤ P, Q ≤ 109
     * */
    private static Map<Long, Long> seq = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] npq = br.readLine().split(" ");
        long n = Long.parseLong(npq[0]);
        if (n == 0) {
            System.out.println(1);
        } else {
            int p = Integer.parseInt(npq[1]);
            int q = Integer.parseInt(npq[2]);
            System.out.println(get0(n, p, q));
        }
        br.close();
    }

    public static long get0(long n, int p, int q) {
        if (n == 0) {
            return 1;
        }
        if (seq.containsKey(n)) {
            return seq.get(n);
        }
        long result = get0(n/p, p, q) + get0(n/q, p, q);
        seq.put(n, result);
        return result;
    }
}
