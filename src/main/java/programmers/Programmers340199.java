package programmers;

import java.util.Arrays;

/**
 * 프로그래머스
 * - 코딩테스트 연습 - PCCP 기출문제 - 지폐 접기 (https://school.programmers.co.kr/learn/courses/30/lessons/340199)
 *
 * 문제 설명
 * - 민수는 다양한 지폐를 수집하는 취미를 가지고 있습니다. 지폐마다 크기가 달라 지갑에 넣으려면 여러 번 접어서 넣어야 합니다.
 * 예를 들어 지갑의 크기가 30 * 15이고 지폐의 크기가 26 * 17이라면 한번 반으로 접어 13 * 17 크기로 만든 뒤 90도 돌려서 지갑에 넣을 수 있습니다.
 * 지폐를 접을 때는 다음과 같은 규칙을 지킵니다.
 *
 *      지폐를 접을 때는 항상 길이가 긴 쪽을 반으로 접습니다.
 *      접기 전 길이가 홀수였다면 접은 후 소수점 이하는 버립니다.
 *      접힌 지폐를 그대로 또는 90도 돌려서 지갑에 넣을 수 있다면 그만 접습니다.
 *
 * 지갑의 가로, 세로 크기를 담은 정수 리스트 wallet과 지폐의 가로, 세로 크기를 담은 정수 리스트 bill가 주어질 때, 지갑에 넣기 위해서 지폐를 최소 몇 번 접어야 하는지 return하도록 solution함수를 완성해 주세요.
 *
 * 제한사항
 *  - wallet의 길이 = bill의 길이 = 2
 *  - 10 ≤ wallet[0], wallet[1] ≤ 100
 *  - 10 ≤ bill[0], bill[1] ≤ 2,000
 */
public class Programmers340199 {

    public static void main(String[] args) {
        final int[] wallet1 = {30, 15};
        final int[] bill1 = {26, 17};

        final int[] wallet2 = {50, 50};
        final int[] bill2 = {100, 241};

        System.out.println(solution(wallet1, bill1));
        System.out.println(solution(wallet2, bill2));
    }

    public static int solution(int[] wallet, int[] bill) {
        int count = 0;

        boolean flag = true;
        while (flag) {
            final int walletMax = Math.max(wallet[0], wallet[1]);
            final int walletMin = Math.min(wallet[0], wallet[1]);
            final int billMax = Math.max(bill[0], bill[1]);
            final int billMin = Math.min(bill[0], bill[1]);

            if (walletMax >= billMax && walletMin >= billMin) flag = false;
            else {
                if (bill[0] >= bill[1]) bill[0] /= 2;
                else bill[1] /= 2;
                count++;
            }
        }

        return count;
    }

}
