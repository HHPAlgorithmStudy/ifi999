package programmers;

import java.util.Arrays;

/**
 * 프로그래머스
 * - 코딩테스트 연습 - 월간 코드 챌린지 시즌3 - n^2 배열 자르기 (https://school.programmers.co.kr/learn/courses/30/lessons/87390)
 *
 * 문제 설명
 * - 2차원 행렬 arr1과 arr2를 입력받아, arr1에 arr2를 곱한 결과를 반환하는 함수, solution을 완성해주세요.
 *
 * 제한 조건
 * - 행렬 arr1, arr2의 행과 열의 길이는 2 이상 100 이하입니다.
 * - 행렬 arr1, arr2의 원소는 -10 이상 20 이하인 자연수입니다.
 * - 곱할 수 있는 배열만 주어집니다.
 *
 * 풀이
 * - O(N^3) - 최대 100까지 가능
 */
public class Programmers12949 {

    public static void main(String[] args) {
        final int[][] left1 = {
                {1, 4},
                {3, 2},
                {4, 1}
        };
        final int[][] right1 = {
                {3, 3},
                {3, 3}
        };

        final int[][] left2 = {
                {2, 3, 2},
                {4, 2, 4},
                {3, 1, 4}
        };
        final int[][] right2 = {
                {5, 4, 3},
                {2, 4, 1},
                {3, 1, 1}
        };

        for (int[] arr : solution(left1, right1)) {
            System.out.println(Arrays.toString(arr));
        }

        System.out.println("=====");

        for (int[] arr : solution(left2, right2)) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        final int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                for (int k = 0; k < arr1[0].length; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }

}
