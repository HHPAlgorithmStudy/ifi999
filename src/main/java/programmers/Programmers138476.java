package programmers;

import java.util.*;

/**
 * 프로그래머스
 * - 코딩테스트 연습 - 연습문제 - 귤 고르기 (https://school.programmers.co.kr/learn/courses/30/lessons/138476)
 *
 * 문제 설명
 * - 경화는 과수원에서 귤을 수확했습니다. 경화는 수확한 귤 중 'k'개를 골라 상자 하나에 담아 판매하려고 합니다.
 * 그런데 수확한 귤의 크기가 일정하지 않아 보기에 좋지 않다고 생각한 경화는 귤을 크기별로 분류했을 때 서로 다른 종류의 수를 최소화하고 싶습니다.
 * 예를 들어, 경화가 수확한 귤 8개의 크기가 [1, 3, 2, 5, 4, 5, 2, 3] 이라고 합시다.
 * 경화가 귤 6개를 판매하고 싶다면, 크기가 1, 4인 귤을 제외한 여섯 개의 귤을 상자에 담으면, 귤의 크기의 종류가 2, 3, 5로 총 3가지가 되며 이때가 서로 다른 종류가 최소일 때입니다.
 * 경화가 한 상자에 담으려는 귤의 개수 k와 귤의 크기를 담은 배열 tangerine이 매개변수로 주어집니다.
 * 경화가 귤 k개를 고를 때 크기가 서로 다른 종류의 수의 최솟값을 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * - 1 ≤ k ≤ tangerine의 길이 ≤ 100,000
 * - 1 ≤ tangerine의 원소 ≤ 10,000,000
 *
 * 풀이
 * - O(NlogN)
 */
public class Programmers138476 {

    public static void main(String[] args) {
        final int k1 = 6;
        final int[] tangerine1 = {1, 3, 2, 5, 4, 5, 2, 3};

        final int k2 = 4;
        final int[] tangerine2 = {1, 3, 2, 5, 4, 5, 2, 3};

        final int k3 = 2;
        final int[] tangerine3 = {1, 1, 1, 1, 2, 2, 2, 3};

        System.out.println(solution(k1, tangerine1));
        System.out.println(solution(k2, tangerine2));
        System.out.println(solution(k3, tangerine3));
    }

    public static int solution(int k, int[] tangerine) {
        Arrays.sort(tangerine);
        final Map<Integer, Integer> map = new HashMap<>();

        for (int size : tangerine) {
            map.put(size, map.getOrDefault(size, 0) + 1);
        }

        final List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue())); // 내림차순 정렬

        int count = 0;
        int total = 0;

        for (Map.Entry<Integer, Integer> entry : list) {
            total += entry.getValue();
            count++;
            if (total >= k) break;
        }

        return count;
    }

}
