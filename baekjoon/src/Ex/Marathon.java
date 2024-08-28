package Ex;

import java.util.*;

public class Marathon {

    public static void main(String[] args) {
        String[] participant = {"leo","kiki","eden"};
        String[] complete = {"eden","kiki"};
        Marathon marathon = new Marathon();
        System.out.println(marathon.solution_sorting(participant, complete));
        System.out.println(marathon.solution_hash(participant, complete));
    }

    public String solution_sorting(String[] participant, String[] complete) {
        // 1. 두 배열을 sorting
        Arrays.sort(participant);
        Arrays.sort(complete);

        // 2. 두 배열이 다를 때까지 찾는다.
        int i = 0;
        for (; i < complete.length; i++) {
            if (!participant[i].equals(complete[i])) {
                break;
            }
        }
        // 3. ``여기까지 왔다면, 마지막 주자가 완주하지 못한것
        return participant[i];
    }

    public String solution_hash(String[] participant, String[] complete) {
        String answer = "";
        // 1. hash map 생성 : participant
        HashMap<String, Integer> map = new HashMap<>();
        for (String player : participant) {
            // getOrDefault : player 값찾아서 없다면 0 있다면 value 값 + 1
            map.put(player, map.getOrDefault(player, 0) + 1);
        }

        // 2. hash map 제외 : complete
        for (String player : complete) {
            map.put(player, map.get(player) - 1);
        }

        // 3. value가 0이 아닌 마지막 주자 찾는다.
        // keySet : map 의 key를 배열로 담아서 검색
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                answer = key;
                break;
            }
        }

        return answer;
    }

}
