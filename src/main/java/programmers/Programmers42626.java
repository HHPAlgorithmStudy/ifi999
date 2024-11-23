package programmers;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 프로그래머스
 * - 코딩테스트 연습 - 힙 - 더 맵게 (https://school.programmers.co.kr/learn/courses/30/lessons/42626)
 *
 * 문제 설명
 * - 매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다.
 * 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 Leo는 스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.
 *
 *      섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
 *
 * Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
 * Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때,
 * 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한 사항
 * - scoville의 길이는 2 이상 1,000,000 이하입니다.
 * - K는 0 이상 1,000,000,000 이하입니다.
 * - scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
 * - 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
 *
 * 풀이
 * - 우선순위 큐 -> O(logN)
 * - 시간복잡도: O(NlogN)
 *   -> 우선순위 큐에서 가장 작은 값 꺼내는 시간: O(logN) -> 탐색 소요시간
 *   -> 최대 반복 횟수가 N -1
 *   --> 시간 복잡도는 O(NlogN)
 */
public class Programmers42626 {

    public static void main(String[] args) {
        final int[] scoville = {1,2,3,9,10,12};
        final int k = 7;

        System.out.println(solution(scoville, k));
    }

    public static int solution(int[] scoville, int k) {
        final Queue<Integer> queue = new PriorityQueue<>(); // 작은 숫자부터
        for (Integer i : scoville) {
            queue.offer(i);
        }

        int count = 0;

        while (!queue.isEmpty() && queue.peek() < k) {
            if (queue.size() == 1) return -1;

            if (queue.peek() < k) {
                final int newScoville = queue.poll() + (queue.poll() * 2);
                queue.offer(newScoville);
                count++;
            }
        }

        return count;
    }

}
