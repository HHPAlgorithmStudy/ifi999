package programmers;

import java.util.Arrays;

/**
 * 프로그래머스
 * - 코딩테스트 연습 - 월간 코드 챌린지 시즌3 - n^2 배열 자르기 (https://school.programmers.co.kr/learn/courses/30/lessons/87390)
 *
 * 문제 설명
 * - 정수 n, left, right가 주어집니다. 다음 과정을 거쳐서 1차원 배열을 만들고자 합니다.
 *
 *  1. n행 n열 크기의 비어있는 2차원 배열을 만듭니다.
 *  2. i = 1, 2, 3, ..., n에 대해서, 다음 과정을 반복합니다.
 *      - 1행 1열부터 i행 i열까지의 영역 내의 모든 빈 칸을 숫자 i로 채웁니다.
 *  3. 1행, 2행, ..., n행을 잘라내어 모두 이어붙인 새로운 1차원 배열을 만듭니다.
 *  4. 새로운 1차원 배열을 arr이라 할 때, arr[left], arr[left+1], ..., arr[right]만 남기고 나머지는 지웁니다.
 * 정수 n, left, right가 매개변수로 주어집니다. 주어진 과정대로 만들어진 1차원 배열을 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * - 1 ≤ n ≤ 107
 * - 0 ≤ left ≤ right < n2
 * - right - left < 105
 *
 * 풀이
 * - O(N)
 */
public class Programmers87390 {

    public static void main(String[] args) {
        final int n1 = 3;
        final int left1 = 2;
        final int right1 = 5;

        final int n2 = 4;
        final int left2 = 7;
        final int right2 = 14;

        System.out.println(Arrays.toString(solution(n1, left1, right1)));
        System.out.println(Arrays.toString(solution(n2, left2, right2)));
    }

    public static int[] solution(int n, long left, long right) {
        final int[] arr = new int[(int)(right - left + 1)];

//        int idx = 0; // i - left 대체 가능
        for (long i = left; i <= right; i++) {
            long x = i / n;
            long y = i % n;

            arr[(int)(i - left)] = (int)Math.max(x + 1, y + 1);
        }

        return arr;
    }

}
