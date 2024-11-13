package programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 프로그래머스
 * - 코딩테스트 연습 - DFS/BFS - 게임 맵 최단거리 (https://school.programmers.co.kr/learn/courses/30/lessons/1844)
 *
 * 문제 설명
 * ROR 게임은 두 팀으로 나누어서 진행하며, 상대 팀 진영을 먼저 파괴하면 이기는 게임입니다.
 * 따라서, 각 팀은 상대 팀 진영에 최대한 빨리 도착하는 것이 유리합니다.
 *
 * (그림 링크 참고)
 *
 * 게임 맵의 상태 maps가 매개변수로 주어질 때, 캐릭터가 상대 팀 진영에 도착하기 위해서 지나가야 하는 칸의 개수의 최솟값을 return 하도록 solution 함수를 완성해주세요.
 * 단, 상대 팀 진영에 도착할 수 없을 때는 -1을 return 해주세요.
 *
 * 제한사항
 * - maps는 n x m 크기의 게임 맵의 상태가 들어있는 2차원 배열로, n과 m은 각각 1 이상 100 이하의 자연수입니다.
 *      - n과 m은 서로 같을 수도, 다를 수도 있지만, n과 m이 모두 1인 경우는 입력으로 주어지지 않습니다.
 * - maps는 0과 1로만 이루어져 있으며, 0은 벽이 있는 자리, 1은 벽이 없는 자리를 나타냅니다.
 * - 처음에 캐릭터는 게임 맵의 좌측 상단인 (1, 1) 위치에 있으며, 상대방 진영은 게임 맵의 우측 하단인 (n, m) 위치에 있습니다.
 *
 * 풀이
 * - BFS: O(N*M)
 *   - N: 배열 행 길이
 *   - M: 배열 열 길이
 */
public class Programmers1844 {

    // 방향 설정
    private static final int[] dx = {-1, 1, 0, 0}; // 행 변화량
    private static final int[] dy = {0, 0, -1, 1}; // 열 변화량

    public static void main(String[] args) {
        final int[][] maps1 = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };

        final int[][] maps2 = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1}
        };

        System.out.println(solution(maps1));
        System.out.println(solution(maps2));
    }

    public static int solution(int[][] maps) {
        final int n = maps.length;
        final int m = maps[0].length;

        final boolean[][] visited = new boolean[n][m]; // 방문 여부
        visited[0][0] = true; // 시작점

        Queue<Node> queue = new LinkedList(); // BFS
        queue.add(new Node(0, 0, 0)); // 시작 위치 [0][0], 이동거리 0

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            // 목적지 도달
            if (current.x == n - 1 && current.y == m - 1) {
                return current.distance + 1;
            }

            // 상하좌우 이동
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                /*
                 * 1. nx >= 0 && nx < n
                 *   - 행 범위 내
                 * 2. ny >= 0 && ny < m
                 *   - 열 범위 내
                 * 3. !visited[nx][ny]
                 *   - 방문하지 않은 배열
                 * 4. maps[nx][ny] == 1
                 *   - 이동 가능한 배열
                 */
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && maps[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.add(new Node(nx, ny, current.distance + 1));
                }
            }

        }

        return -1;
    }

    // 위치 및 이동거리 정보 노드
    static class Node {
        int x;
        int y;
        int distance;

        public Node(final int x, final int y, final int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

}
