package programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * 프로그래머스
 * - 코딩테스트 연습 - 완전탐색 - 모의고사 (https://school.programmers.co.kr/learn/courses/30/lessons/42840)
 *
 * 문제 설명
 * - 수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다.
 * 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
 *
 * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5,                    1, 2, 3, 4, 5, ...
 * 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5,           2, 1, 2, 3, 2, 4, 2, 5, ...
 * 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5,     3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
 *
 * 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때,
 * 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한 조건
 * - 시험은 최대 10,000 문제로 구성되어있습니다.
 * - 문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
 * - 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
 *
 * 풀이
 * -
 */
public class Programmers42840 {

    public static void main(String[] args) {
        final int[] answers1 = {1,2,3,4,5};
        final int[] answers2 = {1,3,2,4,2};

        final int[] result1 = solution(answers1);
        final int[] result2 = solution(answers2);

        for (int n : result1) {
            System.out.println(n);
        }

        System.out.println("==========");

        for (int n : result2) {
            System.out.println(n);
        }
    }

    public static int[] solution(int[] answers) {
        final int[] first = {1, 2, 3, 4, 5};
        int firstCount = 0;
        final int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int secondCount = 0;
        final int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int thirdCount = 0;

        final int length = answers.length;
        for (int i = 0; i < length; i++) {
            final int answer = answers[i];

            if (answer == first[i % first.length]) firstCount++;
            if (answer == second[i % second.length]) secondCount++;
            if (answer == third[i % third.length]) thirdCount++;
        }

        final int max = Math.max(firstCount, Math.max(secondCount, thirdCount));

        final List<Integer> list = new ArrayList<>();
        if (max == firstCount) list.add(1);
        if (max == secondCount) list.add(2);
        if (max == thirdCount) list.add(3);

        return list.stream()
                .mapToInt(i -> i)
                .toArray();
    }

}
