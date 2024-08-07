package BaekJoon.week3;

import java.util.*;
public class Sol_3_24544 {
    /**
     * 카카오뷰 큐레이팅 효용성 분석
     *
     * 카카오뷰는 사용자가 관심을 가질만한 주제를 분석하고,이를 바탕으로 큐레이팅을 진행하는 카카오톡의 서비스이다.
     * '발견'을 통해 흥미로운 주제의 콘텐츠를 탐색하고, 마음에 드는 콘텐츠는 My뷰에 등록해서 지속적으로 구독할 수 있다.
     * 많은 사람들은 이 카카오뷰를 코로나 체크인 QR코드 용도로만 활용하고 있겠지만 사실은 더욱 대단한 일을 할 수 있는 서비스로서 잠재력이 높다.
     *
     * 카카오톡 신입으로 입사한 gumgood은 자신이 고안해낸 콘텐츠 큐레이팅 알고리즘인 good-gum을 고안해냈다.
     * gumgood은 자신이 고안한 알고리즘이 얼마나 유용한지 분석하고 싶다.
     *
     * 현재 각 콘텐츠별로 사용자가 관심을 가질만한 정도를 나타내는 점수를 정수 형태로 계산해 놓은 상태이다.
     * (이후 이 문제에서는 해당 점수를 '흥미도'라고 표현하겠다.)
     *
     * My뷰에 등록된 콘텐츠도 중요하지만, '발견'을 통해 사용자에게 새로운,
     * 그리고 흥미로운 콘텐츠를 추천하는 것이 큐레이팅 서비스의 운명이다.
     * 따라서 My뷰에 등록되지 않은 콘텐츠 중 흥미도의 합이 큐레이팅 알고리즘의 유용함의 척도가 될 것이다.
     *
     * 현재 good-gum알고리즘을 통해 사용자에게 총 N개의 콘텐츠가 추천된 상태이다.
     * 이 각 콘텐츠 별로 계산된 흥미도 값과 해당 콘텐츠가 이미 My뷰에 등록되어 있는지 여부가 주어졌을 때,
     * 전체 흥미도의 합과 My뷰에 등록되지 않은 콘텐츠의 흥미도의 합을 각각 구해서 큐레이팅 알고리즘이 얼마나 유용한지를 분석해보자.
     *
     * 입력
     * 첫 번째 줄에 콘텐츠의 개수 N이 주어진다. (1 <= N <= 1,000)
     *
     * 두 번째 줄에는 콘텐츠의 흥미도를 나타내는 N개의 정수가 공백을 사이에 두고 주어진다.
     * i 번째로 주어지는 값 A_i는 i번 콘텐츠의 흥미도이다. (0 <= A_i <= 1,000,000)
     *
     * 세 번째 줄에는 My뷰에 등록되어 있는지 여부를 나타내는 N개의 값이 공백을 사이에 두고 주어진다.
     * i 번째로 주어지는 값 B_i는 i번 콘텐츠가 이미 My뷰에 등록이 되어있는 경우에는 1, 등록되어있지 않은 아닌 경우에는 0이다.
     *
     * 출력
     * 첫째 줄에는 전체 콘텐츠의 흥미도의 합을 출력한다.
     *
     * 둘째 줄에는 My뷰에 등록되어있지 않은 콘텐츠들의 흥미도의 합을 출력한다.
     *
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int repeat = Integer.parseInt(sc.nextLine());

        String[] interest = sc.nextLine().split(" ");
        int total = 0;
        for (int i = 0; i < repeat; i++) {
            total += Integer.parseInt(interest[i]);
        }
        sb.append(total).append("\n");

        String[] my = sc.nextLine().split(" ");
        int myView = 0;
        for (int i = 0; i < repeat; i++) {
            if (my[i].equals("0")) {
                myView += Integer.parseInt(interest[i]);
            }
        }
        sb.append(myView).append("\n");

        System.out.println(sb);
        sc.close();
    }
}
