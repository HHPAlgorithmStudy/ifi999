package programmers;

/**
 * 프로그래머스
 * - 코딩테스트 연습 - 완전탐색 - 카펫 (https://school.programmers.co.kr/learn/courses/30/lessons/42842)
 *
 * 문제 설명
 * - Leo는 카펫을 사러 갔다가 아래 그림과 같이 중앙에는 노란색으로 칠해져 있고 테두리 1줄은 갈색으로 칠해져 있는 격자 모양 카펫을 봤습니다.
 * Leo는 집으로 돌아와서 아까 본 카펫의 노란색과 갈색으로 색칠된 격자의 개수는 기억했지만, 전체 카펫의 크기는 기억하지 못했습니다.
 * Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때
 * 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * - 갈색 격자의 수 brown은 8 이상 5,000 이하인 자연수입니다.
 * - 노란색 격자의 수 yellow는 1 이상 2,000,000 이하인 자연수입니다.
 * - 카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
 *
 * 풀이
 * - 풀이1: O(N^2)
 * - 풀이2: O(sqrt(N))
 */
public class Programmers42842 {

    public static void main(String[] args) {
        final int brown1 = 10;
        final int brown2 = 8;
        final int brown3 = 24;

        final int yellow1 = 2;
        final int yellow2 = 1;
        final int yellow3 = 24;

        for (int i : solution2(brown1, yellow1)) {
            System.out.println(i);
        }

        System.out.println("---------");

        for (int i : solution2(brown2, yellow2)) {
            System.out.println(i);
        }

        System.out.println("---------");

        for (int i : solution2(brown3, yellow3)) {
            System.out.println(i);
        }
    }

    public static int[] solution(int brown, int yellow) {
        final int sum = brown + yellow;

        for (int i = 2; i <= Math.sqrt(sum); i++) {
            if (sum % i == 0) {
                final int[][] arr = new int[sum / i][i];
                int brownCount = 0;

                for (int j = 0; j < arr.length; j++) {
                    for (int k = 0; k < arr[0].length; k++) {
                        if (j == 0 || j == arr.length - 1 || k == 0 || k == arr[0].length - 1) brownCount++;
                    }
                }

                if (brownCount == brown) return new int[]{sum / i, i};
            }
        }

        return new int[]{};
    }

    /*
     * 그림 그려서 생각
     * 1. brown = (width * 2) + (height * 2) - 4
     * 2. yellow = (width - 2) * (height - 2)
     */
    public static int[] solution2(int brown, int yellow) {
        int sum = brown + yellow;

        for (int height = 3; height <= Math.sqrt(sum); height++) {
            if (sum % height == 0) {
                final int width = sum / height;

                if ((width -2) * (height - 2) == yellow) {
                    return new int[]{width, height};
                }
            }
        }

        return new int[]{};
    }

}
