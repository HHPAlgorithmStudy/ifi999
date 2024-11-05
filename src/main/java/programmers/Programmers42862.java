package programmers;

import java.util.Arrays;

/**
 * 프로그래머스
 * - 코딩테스트 연습 - 탐욕법(Greedy) - 체육복 (https://school.programmers.co.kr/learn/courses/30/lessons/42862)
 *
 * 문제 설명
 * 점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다.
 * 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다.
 * 학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다.
 * 예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다.
 * 체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.
 *
 * 전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost,
 * 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때,
 * 체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 *  - 전체 학생의 수는 2명 이상 30명 이하입니다.
 *  - 체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
 *  - 여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
 *  - 여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
 *  - 여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
 *
 * 풀이
 * -
 */
public class Programmers42862 {

    public static void main(String[] args) {
        final int n1 = 5;
        final int[] lost1 = {2, 4};
        final int[] reserve1 = {1, 3, 5};

        final int n2 = 5;
        final int[] lost2 = {2, 4};
        final int[] reserve2 = {3};

        final int n3 = 3;
        final int[] lost3 = {3};
        final int[] reserve3 = {1};

        final int n4 = 5;
        final int[] lost4 = {5, 3};
        final int[] reserve4 = {4, 2};

        System.out.println(solution(n1, lost1, reserve1));
        System.out.println(solution(n2, lost2, reserve2));
        System.out.println(solution(n3, lost3, reserve3));
        System.out.println(solution(n4, lost4, reserve4));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] clothes = new int[n + 1]; // 1번 학생부터 이므로 +1
        final int length = clothes.length;
        Arrays.fill(clothes, 1); // 기본 보유 개수 1

        for (int i = 1; i < length; i++) {
            // 도난 카운팅
            for (int idx : lost) {
                if (i == idx) clothes[i]--;
            }

            // 여분 카운팅
            for (int idx : reserve) {
                if (i == idx) clothes[i]++;
            }
        }

        for (int i = 1; i < length; i++) {
            final int clothe = clothes[i];
            // 앞번호 학생 체육복이 없을 경우
            if (clothe > 1 && clothes[i - 1] == 0) {
                clothes[i - 1]++;
                clothes[i]--;
            }
            // 뒷번호 학생 체육복이 없을 경우
            else if (clothe > 1 && i + 1 < length && clothes[i + 1] == 0) {
                clothes[i + 1]++;
                clothes[i]--;
            }
        }

        // 체육복 보유 중인 학생수 카운팅
        for (int i = 1; i < length; i++) {
            if (clothes[i] != 0) answer++;
        }

        return answer;
    }

}
