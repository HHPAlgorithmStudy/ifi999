package programmers;

import java.util.Arrays;

/**
 * 프로그래머스
 * - 코딩테스트 연습 - 정렬 - 가장 큰 수 (https://school.programmers.co.kr/learn/courses/30/lessons/42746)
 *
 * 문제 설명
 * - 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
 * 예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
 * 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한 사항
 * - numbers의 길이는 1 이상 100,000 이하입니다.
 * - numbers의 원소는 0 이상 1,000 이하입니다.
 * - 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
 *
 * 풀이
 * - 정렬(TimSort) : O(NlogN)
 */
public class Programmers42746 {

    public static void main(String[] args) {
        final int[] numbers1 = {6, 10, 2};
        final int[] numbers2 = {3, 30, 34, 5, 9};

        System.out.println(solution(numbers1));
        System.out.println(solution(numbers2));
    }

    public static String solution(int[] numbers) {
        final String[] strNumbers = new String[numbers.length];

        // 문자열 변환
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }

        // 정렬. (b + a)가 더 크면 앞에 옴
        Arrays.sort(strNumbers, (a, b) -> (b + a).compareTo(a + b));

        // 모든 숫자가 0
        if (strNumbers[0].equals("0")) return "0";

        // 구분자 없이 문자열 붙이기
        return String.join("", strNumbers);
    }

}
