package BaekJoon.week5;

import java.util.*;
import java.io.*;

public class Sol_5_2002 {

    /**
     * 대한민국을 비롯한 대부분의 나라에서는 터널 내에서의 차선 변경을 법률로 금하고 있다.
     * 조금만 관찰력이 있는 학생이라면 터널 내부에서는 차선이 파선이 아닌 실선으로 되어 있다는 것을 알고 있을 것이다.
     * 이는 차선을 변경할 수 없음을 말하는 것이고, 따라서 터널 내부에서의 추월은 불가능하다.
     *
     * 소문난 명콤비 경찰 대근이와 영식이가 추월하는 차량을 잡기 위해 한 터널에 투입되었다.
     * 대근이는 터널의 입구에, 영식이는 터널의 출구에 각각 잠복하고,
     * 대근이는 차가 터널에 들어가는 순서대로,
     * 영식이는 차가 터널에서 나오는 순서대로 각각 차량 번호를 적어 두었다.
     *
     * N개의 차량이 지나간 후, 대근이와 영식이는 자신들이 적어 둔 차량 번호의 목록을 보고,
     * 터널 내부에서 반드시 추월을 했을 것으로 여겨지는 차들이 몇 대 있다는 것을 알게 되었다.
     * 대근이와 영식이를 도와 이를 구하는 프로그램을 작성해 보자.
     *
     * 입력
     * 입력은 총 2N+1개의 줄로 이루어져 있다.
     * 첫 줄에는 차의 대수 N(1 ≤ N ≤ 1,000)이 주어진다.
     * 둘째 줄부터 N개의 줄에는 대근이가 적은 차량 번호 목록이 주어지고,
     * N+2째 줄부터 N개의 줄에는 영식이가 적은 차량 번호 목록이 주어진다.
     * 각 차량 번호는 6글자 이상 8글자 이하의 문자열로, 영어 대문자('A'-'Z')와 숫자('0'-'9')로만 이루어져 있다.
     * 같은 차량 번호가 두 번 이상 주어지는 경우는 없다.
     *
     * 출력
     * 첫째 줄에 터널 내부에서 반드시 추월을 했을 것으로 여겨지는 차가 몇 대인지 출력한다.
     *
     * 4
     * A
     * B
     * C
     * D
     * D
     * B
     * C
     * A
     * >> RESULT : 3
     *
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());

        Deque<String> in = new ArrayDeque<>();
        Deque<String> out = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            in.addLast(br.readLine());
        }
        for (int i = 1; i <= n; i++) {
            out.addLast(br.readLine());
        }
        int result = 0;
        while (!out.isEmpty()) {
            String car = out.pollFirst();

            if (in.peekFirst().equals(car)) {
                in.pollFirst();
            } else {
                result++;
                in.remove(car);
            }
        }
        System.out.println(result);
        br.close();
    }
}