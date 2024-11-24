package programmers;

import java.util.Arrays;

/**
 * 프로그래머스
 * - 코딩테스트 연습 - 연습문제 - 최댓값과 최솟값 (https://school.programmers.co.kr/learn/courses/30/lessons/12939)
 *
 * 문제 설명
 * - 문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다.
 * str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수, solution을 완성하세요.
 * 예를들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고, "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.
 *
 * 제한 조건
 * - s에는 둘 이상의 정수가 공백으로 구분되어 있습니다.
 *
 * 풀이
 * - 순회, 정렬
 * - 시간복잡도: O(NlogN)
 */
public class Programmers12939 {

    public static void main(String[] args) {
        final String s1 = "1 2 3 4";
        final String s2 = "-1 -2 -3 -4";
        final String s3 = "-1 -1";

        System.out.println(solution(s1));
        System.out.println(solution(s2));
        System.out.println(solution(s3));
    }

    public static String solution(String s) {
        final String[] arr = s.split(" "); // 문자열 배열 분리

        final int[] intArr = new int[arr.length]; // 문자열 배열 -> 정수 배열
        for (int i = 0; i < arr.length; i++) {
            intArr[i] = Integer.parseInt(arr[i]);
        }

        Arrays.sort(intArr); // O(NlogN)

        final StringBuilder sb = new StringBuilder();
        sb.append(intArr[0]);

        if (intArr.length == 1) return sb.toString();

        sb.append(" ").append(intArr[intArr.length -1]);

        return sb.toString();
    }

}
