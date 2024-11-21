package programmers;

import java.util.*;

/**
 * 프로그래머스
 * - 코딩 테스트 연습 - DFS/BFS - 여행경로 (https://school.programmers.co.kr/learn/courses/30/lessons/43164)
 *
 * 문제 설명
 * - 주어진 항공권을 모두 이용하여 여행경로를 짜려고 합니다. 항상 "ICN" 공항에서 출발합니다.
 * 항공권 정보가 담긴 2차원 배열 tickets가 매개변수로 주어질 때, 방문하는 공항 경로를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * - 모든 공항은 알파벳 대문자 3글자로 이루어집니다.
 * - 주어진 공항 수는 3개 이상 10,000개 이하입니다.
 * - tickets의 각 행 [a, b]는 a 공항에서 b 공항으로 가는 항공권이 있다는 의미입니다.
 * - 주어진 항공권은 모두 사용해야 합니다.
 * - 만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.
 * - 모든 도시를 방문할 수 없는 경우는 주어지지 않습니다.
 *
 * 풀이
 * -
 */
public class Programmers43164 {

    static boolean[] visited;
    static List<String> result;

    public static void main(String[] args) {
        final String[][] tickets1 = {
                {"ICN", "JFK"},
                {"HND", "IAD"},
                {"JFK", "HND"}
        };

        final String[][] tickets2 = {
                {"ICN", "SFO"},
                {"ICN", "ATL"},
                {"SFO", "ATL"},
                {"ATL", "ICN"},
                {"ATL", "SFO"}
        };

        for (String str : solution2(tickets1)) {
            System.out.println(str);
        }

        System.out.println("================");

        for (String str : solution2(tickets2)) {
            System.out.println(str);
        }
    }

    // 실패
    public static String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));

        String target = "ICN";
        final int n = tickets.length;
        final List<String> list = new ArrayList<>();

        final Queue<String[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(tickets[i]);
        }

        while (!queue.isEmpty()) {
            final String[] current = queue.poll();
            final String startPoint = current[0];

            if (target.equals(startPoint)) {
                list.add(startPoint);

                final String endPoint = current[1];
                target = endPoint;

                if (queue.isEmpty()) list.add(endPoint);
            }
            else {
                queue.add(current);
            }
        }

        final int resultSize = list.size();
        final String[] answer = new String[resultSize];
        for (int i = 0; i < resultSize; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static String[] solution2(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        visited = new boolean[tickets.length];
        result = new ArrayList<>();

        final List<String> path = new ArrayList<>();
        path.add("ICN");

        dfs(tickets, "ICN", path);

        return result.toArray(new String[0]);
    }

    private static void dfs(String[][] tickets, String current, List<String> path) {
        if (path.size() == tickets.length + 1) {
            if (result.isEmpty()) {
                result = new ArrayList<>(path); // 알파벳 순으로 가장 앞서는 경로
            }

            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                path.add(tickets[i][1]);
                dfs(tickets, tickets[i][1], path);
                path.remove(path.size() - 1); // 백트래킹
                visited[i] = false;
            }
        }
    }

}
