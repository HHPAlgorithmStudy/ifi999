package programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 프로그래머스
 * - 코딩테스트 연습 - DFS/BFS - 네트워크 (https://school.programmers.co.kr/learn/courses/30/lessons/43162)
 *
 * 문제 설명
 * - 네트워크란 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태를 의미합니다.
 * 예를 들어, 컴퓨터 A와 컴퓨터 B가 직접적으로 연결되어있고,
 * 컴퓨터 B와 컴퓨터 C가 직접적으로 연결되어 있을 때 컴퓨터 A와 컴퓨터 C도 간접적으로 연결되어 정보를 교환할 수 있습니다.
 * 따라서 컴퓨터 A, B, C는 모두 같은 네트워크 상에 있다고 할 수 있습니다.
 *
 * 컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때, 네트워크의 개수를 return 하도록 solution 함수를 작성하시오.
 *
 * 제한사항
 * - 컴퓨터의 개수 n은 1 이상 200 이하인 자연수입니다.
 * - 각 컴퓨터는 0부터 n-1인 정수로 표현합니다.
 * - i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j]를 1로 표현합니다.
 * - computer[i][i]는 항상 1입니다.
 *
 * 풀이
 * - BFS
 */
public class Programmers43162 {

    public static void main(String[] args) {
        final int n1 = 3;
        final int[][] computers1 = {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };

        final int n2 = 3;
        final int[][] computers2 = {
                {1,1,0},
                {1,1,1},
                {0,1,1}
        };

        System.out.println(solution(n1, computers1));
        System.out.println(solution(n2, computers2));
    }

    public static int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n]; // 어차피 행렬이니까 대칭이라 1차원 배열
        int networkCount = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, computers, visited);
                networkCount++;
            }
        }

        return networkCount;
    }

    private static void bfs(int start, int[][] computers, boolean[] visited) {
        final Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true; // 시작점 방문 처리

        while (!queue.isEmpty()) {
            final Integer current = queue.poll();

            for (int i = 0; i < computers.length; i++) {
                if (computers[current][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

}
