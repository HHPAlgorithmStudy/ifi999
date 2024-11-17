package programmers;

import java.util.*;

/**
 * 프로그래머스
 * - 코딩 테스트 연습 - DFS/BFS - 단어 변환 (https://school.programmers.co.kr/learn/courses/30/lessons/43163)
 *
 * 문제 설명
 * - 두 개의 단어 begin, target과 단어의 집합 words가 있습니다.
 * 아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.
 *
 *      1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
 *      2. words에 있는 단어로만 변환할 수 있습니다.
 *
 * 예를 들어 begin이 "hit", target가 "cog", words가
 * ["hot","dot","dog","lot","log","cog"]라면
 * "hit" -> "hot" -> "dot" -> "dog" -> "cog"와 같이 4단계를 거쳐 변환할 수 있습니다.
 *
 * 두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때,
 * 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * - 각 단어는 알파벳 소문자로만 이루어져 있습니다.
 * - 각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같습니다.
 * - words에는 3개 이상 50개 이하의 단어가 있으며 중복되는 단어는 없습니다.
 * - begin과 target은 같지 않습니다.
 * - 변환할 수 없는 경우에는 0를 return 합니다.
 *
 * 풀이
 * -
 */
public class Programmers43163 {

    public static void main(String[] args) {
        final String begin1 = "hit";
        final String begin2 = "hit";

        final String target1 = "cog";
        final String target2 = "cog";

        final String[] words1 = {"hot", "dot", "dog", "lot", "log", "cog"};
        final String[] words2 = {"hot", "dot", "dog", "lot", "log"};

        System.out.println(solution(begin1, target1, words1)); // 4
        System.out.println(solution(begin2, target2, words2)); // 0
    }

    public static Map<String, List<String>> buildGraph(String begin, String[] words) {
        final List<String> allWords = new ArrayList<>(Arrays.asList(words));
        allWords.add(begin);

        // 그래프
        final Map<String, List<String>> graph = new HashMap<>();
        for (String word : allWords) {
            graph.put(word, new ArrayList<>());
        }

        // 각 단어 간 간선 추가
        for (int i = 0; i < allWords.size(); i++) {
            for (int j = i + 1; j < allWords.size(); j++) {
                String word1 = allWords.get(i);
                String word2 = allWords.get(j);
                if (canTransform(word1, word2)) {
                    graph.get(word1).add(word2);
                    graph.get(word2).add(word1);
                }
            }
        }

        return graph;
    }

    private static boolean canTransform(String word1, String word2) {
        int diffCount = 0;

        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCount++;
            }

            if (diffCount > 1) return false;
        }

        return diffCount == 1;
    }

    public static int solution(String begin, String target, String[] words) {
        // target이 words에 없으면 변환 불가능
        if (!Arrays.asList(words).contains(target)) return 0;

        // 그래프 생성
        final Map<String, List<String>> graph = buildGraph(begin, words);

        // BFS
        final Queue<String> queue = new LinkedList<>();
        final Map<String, Integer> visited = new HashMap<>();
        queue.offer(begin);
        visited.put(begin, 0); // 시작 단어의 변환 단계는 0

        // BFS 탐색
        while (!queue.isEmpty()) {
            final String current = queue.poll();
            final int steps = visited.get(current);

            // 목표 단어에 도달하면 반환
            if (current.equals(target)) {
                return steps;
            }

            // 인접 단어 탐색
            for (String neighbor : graph.get(current)) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, steps + 1);
                    queue.offer(neighbor);
                }
            }
        }

        return 0;
    }

}
