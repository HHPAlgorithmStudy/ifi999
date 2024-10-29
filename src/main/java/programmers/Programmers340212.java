package programmers;

/**
 * 프로그래머스
 * - 코딩테스트 연습 - PCCP 기출문제 - 퍼즐 게임 챌린지 (https://school.programmers.co.kr/learn/courses/30/lessons/340212)
 *
 * 문제 설명
 * - 당신은 순서대로 n개의 퍼즐을 제한 시간 내에 풀어야 하는 퍼즐 게임을 하고 있습니다. 각 퍼즐은 난이도와 소요 시간이 정해져 있습니다.
 * 당신의 숙련도에 따라 퍼즐을 풀 때 틀리는 횟수가 바뀌게 됩니다.
 * 현재 퍼즐의 난이도를 diff, 현재 퍼즐의 소요 시간을 time_cur, 이전 퍼즐의 소요 시간을 time_prev, 당신의 숙련도를 level이라 하면, 게임은 다음과 같이 진행됩니다.
 *
 *      - diff ≤ level이면 퍼즐을 틀리지 않고 time_cur만큼의 시간을 사용하여 해결합니다.
 *      - diff > level이면, 퍼즐을 총 diff - level번 틀립니다. 퍼즐을 틀릴 때마다, time_cur만큼의 시간을 사용하며,
 *        추가로 time_prev만큼의 시간을 사용해 이전 퍼즐을 다시 풀고 와야 합니다. 이전 퍼즐을 다시 풀 때는 이전 퍼즐의 난이도에 상관없이 틀리지 않습니다.
 *        diff - level번 틀린 이후에 다시 퍼즐을 풀면 time_cur만큼의 시간을 사용하여 퍼즐을 해결합니다.
 *
 * 예를 들어 diff = 3, time_cur = 2, time_prev = 4인 경우, level에 따라 퍼즐을 푸는데 걸리는 시간은 다음과 같습니다.
 *
 *      - level = 1이면, 퍼즐을 3 - 1 = 2번 틀립니다. 한 번 틀릴 때마다 2 + 4 = 6의 시간을 사용하고, 다시 퍼즐을 푸는 데 2의 시간을 사용하므로 총 6 × 2 + 2 = 14의 시간을 사용하게 됩니다.
 *      - level = 2이면, 퍼즐을 3 - 2 = 1번 틀리므로, 6 + 2 = 8의 시간을 사용하게 됩니다.
 *      - level ≥ 3이면 퍼즐을 틀리지 않으며, 2의 시간을 사용하게 됩니다.
 *
 * 퍼즐 게임에는 전체 제한 시간 limit가 정해져 있습니다. 제한 시간 내에 퍼즐을 모두 해결하기 위한 숙련도의 최솟값을 구하려고 합니다.
 * 난이도, 소요 시간은 모두 양의 정수며, 숙련도도 양의 정수여야 합니다.
 * 퍼즐의 난이도를 순서대로 담은 1차원 정수 배열 diffs, 퍼즐의 소요 시간을 순서대로 담은 1차원 정수 배열 times, 전체 제한 시간 limit이 매개변수로 주어집니다.
 * 제한 시간 내에 퍼즐을 모두 해결하기 위한 숙련도의 최솟값을 정수로 return 하도록 solution 함수를 완성해 주세요.
 *
 * 제한사항
 * - 1 ≤ diffs의 길이 = times의 길이 = n ≤ 300,000
 *      - diffs[i]는 i번째 퍼즐의 난이도, times[i]는 i번째 퍼즐의 소요 시간입니다.
 *      - diffs[0] = 1
 *      - 1 ≤ diffs[i] ≤ 100,000
 *      - 1 ≤ times[i] ≤ 10,000
 * - 1 ≤ limit ≤ 10^15
 *      - 제한 시간 내에 퍼즐을 모두 해결할 수 있는 경우만 입력으로 주어집니다.
 *
 * 풀이
 * - 이진탐색 : O(n * log(max_diff))
 */
public class Programmers340212 {

    public static void main(String[] args) {
        final int[] diffs1 = {1, 5, 3};
        final int[] times1 = {2, 4, 7};
        final long limit1 = 30L;

        final int[] diffs2 = {1, 4, 4, 2};
        final int[] times2 = {6, 3, 8, 2};
        final long limit2 = 59L;

        final int[] diffs3 = {1, 328, 467, 209, 54};
        final int[] times3 = {2, 7, 1, 4, 3};
        final long limit3 = 1723L;

        final int[] diffs4 = {1, 99999, 100000, 99995};
        final int[] times4 = {9999, 9001, 9999, 9001};
        final long limit4 = 3456789012L;

        System.out.println(solution(diffs1, times1, limit1));
        System.out.println(solution(diffs2, times2, limit2));
        System.out.println(solution(diffs3, times3, limit3));
        System.out.println(solution(diffs4, times4, limit4));
    }

    public static int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 100000; // 최대 난이도

        while (left < right) {
            int mid = (left + right) / 2;
            // 가능한 경우 더 작은 숙련도를 탐색
            if (canSolve(diffs, times, mid, limit)) {
                right = mid;
            } else {
                left = mid + 1; // 불가능한 경우 숙련도 증가
            }
        }

        return left;
    }

    private static boolean canSolve(final int[] diffs, final int[] times, final int level, final long limit) {
        long totalTime = 0;

        for (int i = 0; i < diffs.length; i++) {
            final int diff = diffs[i];
            final int timeCur = times[i];
            final int timePrev = i > 0 ? times[i - 1] : 0;

            if (diff <= level) {
                totalTime += timeCur;
            }
            else {
                final int failCount = diff - level;
                totalTime += (long) failCount * (timeCur + timePrev) + timeCur;
            }

            if (totalTime > limit) return false;
        }

        return totalTime <= limit;
    }

}
