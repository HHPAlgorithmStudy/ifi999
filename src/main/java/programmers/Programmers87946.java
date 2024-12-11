package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 프로그래머스
 * - 코딩테스트 연습 - 완전탐색 - 피로도 (https://school.programmers.co.kr/learn/courses/30/lessons/87946)
 *
 * 문제 설명
 * - XX게임에는 피로도 시스템(0 이상의 정수로 표현합니다)이 있으며, 일정 피로도를 사용해서 던전을 탐험할 수 있습니다.
 * 이때, 각 던전마다 탐험을 시작하기 위해 필요한 "최소 필요 피로도"와 던전 탐험을 마쳤을 때 소모되는 "소모 피로도"가 있습니다.
 * "최소 필요 피로도"는 해당 던전을 탐험하기 위해 가지고 있어야 하는 최소한의 피로도를 나타내며, "소모 피로도"는 던전을 탐험한 후 소모되는 피로도를 나타냅니다.
 * 예를 들어 "최소 필요 피로도"가 80, "소모 피로도"가 20인 던전을 탐험하기 위해서는 유저의 현재 남은 피로도는 80 이상 이어야 하며, 던전을 탐험한 후에는 피로도 20이 소모됩니다.
 * 이 게임에는 하루에 한 번씩 탐험할 수 있는 던전이 여러개 있는데, 한 유저가 오늘 이 던전들을 최대한 많이 탐험하려 합니다. 유저의 현재 피로도 k와 각 던전별 "최소 필요 피로도", "소모 피로도"가 담긴 2차원 배열 dungeons 가 매개변수로 주어질 때, 유저가 탐험할수 있는 최대 던전 수를 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * - k는 1 이상 5,000 이하인 자연수입니다.
 * - dungeons의 세로(행) 길이(즉, 던전의 개수)는 1 이상 8 이하입니다.
 *      - dungeons의 가로(열) 길이는 2 입니다.
 *      - dungeons의 각 행은 각 던전의 ["최소 필요 피로도", "소모 피로도"] 입니다.
 *      - "최소 필요 피로도"는 항상 "소모 피로도"보다 크거나 같습니다.
 *      - "최소 필요 피로도"와 "소모 피로도"는 1 이상 1,000 이하인 자연수입니다.
 *      - 서로 다른 던전의 ["최소 필요 피로도", "소모 피로도"]가 서로 같을 수 있습니다.
 */
public class Programmers87946 {

    public static void main(String[] args) {
        final int k = 80;
        final int[][] dungeons = {
                {80, 20},
                {50, 40},
                {30, 10}
        };

        System.out.println(solution(k, dungeons));
    }

    public static int solution(int k, int[][] dungeons) {
        List<int[]> dungeonList = new ArrayList<>();
        for (int[] dungeon : dungeons) {
            dungeonList.add(dungeon);
        }

        List<List<int[]>> permutations = new ArrayList<>();
        permute(dungeonList, 0, permutations);

//        return explore(k, permutations);
        return permuteAndExplore(dungeons, k, 0);
    }

    private static int explore(final int k, final List<List<int[]>> permutations) {
        int maxCount = 0;

        for (List<int[]> permutation : permutations) {
            int fatigue = k;
            int count = 0;

            for (int[] dungeon : permutation) {
                final int requiredFatigue = dungeon[0];
                final int consumeFatigue = dungeon[1];

                if (fatigue < requiredFatigue) break;

                fatigue -= consumeFatigue;
                count++;
            }

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    // 순열 생성
    private static void permute(final List<int[]> dungeons, final int depth, final List<List<int[]>> permutations) {
        if (depth == dungeons.size()) {
            permutations.add(new ArrayList<>(dungeons));
            return;
        }

        for (int i = depth; i < dungeons.size(); i++) {
            Collections.swap(dungeons, depth, i); // 스왑

            permute(dungeons, depth + 1, permutations);
            Collections.swap(dungeons, depth, i); // 스왑 복구
        }
    }

    // 개선
    private static int permuteAndExplore(final int[][] dungeons, final int fatigue, final int depth) {
        if (depth == dungeons.length) return 0;

        int maxCount = 0;

        for (int i = depth; i < dungeons.length; i++) {
            swap(dungeons, depth, i); // 스왑

            if (fatigue >= dungeons[depth][0]) { // 입장 가능
                int count = 1 + permuteAndExplore(
                        dungeons,
                        fatigue - dungeons[depth][1],
                        depth + 1
                );
                maxCount = Math.max(maxCount, count);
            }
            else { // 입장 불가
                maxCount = Math.max(maxCount, permuteAndExplore(dungeons, fatigue, depth + 1));
            }

            swap(dungeons, depth, i); // 스왑 복구
        }

        return maxCount;
    }

    private static void swap(final int[][] dungeons, final int i, final int j) {
        int[] temp = dungeons[i];
        dungeons[i] = dungeons[j];
        dungeons[j] = temp;
    }

}
