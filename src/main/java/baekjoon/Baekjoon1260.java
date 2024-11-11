package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 백준
 * - 1260번 (https://www.acmicpc.net/problem/1260)
 *
 * 문제
 * - 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
 * 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다.
 * 정점 번호는 1번부터 N번까지이다.
 *
 * 입력
 * - 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다.
 * 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다.
 * 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.
 */
public class Baekjoon1260 {

    public static void main(String[] args) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] str = br.readLine().split(" ");
        final int n = Integer.parseInt(str[0]);
        final int m = Integer.parseInt(str[1]);
        final int v = Integer.parseInt(str[2]);

        final List<Integer>[] graph = new ArrayList[n + 1];
        final boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            final String[] numbers = br.readLine().split(" ");
            final int a = Integer.parseInt(numbers[0]);
            final int b = Integer.parseInt(numbers[1]);
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        dfs(v, graph, visited);
        System.out.println();
        bfs(graph, v, n);
    }

    public static void bfs(List<Integer>[] graph, int start, int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            for (int neighbor : graph[node]) {
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }

        for (int node : result) {
            System.out.print(node + " ");
        }
    }

    public static void dfs(int node, List<Integer>[] graph, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }

}
