package programmers;

import java.util.HashSet;
import java.util.Set;

/**
 * 프로그래머스
 * - 코딩테스트 연습 - PCCP 기출문제 - 붕대 감기 (https://school.programmers.co.kr/learn/courses/30/lessons/250137)
 *
 * 문제 설명
 * - 한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
 * 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 *  - numbers는 길이 1 이상 7 이하인 문자열입니다.
 *  - numbers는 0~9까지 숫자만으로 이루어져 있습니다.
 *  - "013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
 *
 * 풀이
 * - 완전탐색 : O(2^N)
 * - 소수 확인 : O(N*sqrt(M)) - combinationNumbers 개수 N, numbers 크기 M
 *      - 에라토스테네스의 체를 사용하지 않은 이유
 *          - 한 번에 하나의 숫자만 검증하면 됨
 *          - 에라토스테네스의 체 방식은 반복적으로 소수를 확인하는 경우나 범위가 클 경우 유리. 범위 내의 다수의 소수를 검증할 떄 유리
 *          - 해당 문제에서 주어진 숫자가 많이 크다고 생각되지 않아서 사용하지 않음
 */
public class Programmers42839 {

    public static void main(String[] args) {
        final String numbers1 = "17";
        final String numbers2 = "011";

        System.out.println(solution(numbers1));
        System.out.println(solution(numbers2));
    }

    public static int solution(String numbers) {
        int answer = 0;

        // 소수 저장
        Set<Integer> combinationNumbers = new HashSet<>();

        // 숫자 조합
        bruteforce("", numbers, combinationNumbers);

        // 소수 확인
        for (Integer number : combinationNumbers) {
            if (number < 2) continue;

            boolean flag = true;

            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) answer++;
        }

        return answer;
    }

    // 완전 탐색
    private static void bruteforce(String currentNumber, String remainNumbers, Set<Integer> primeSet) {
        // 문자열이 존재한다면 추가
        if (!currentNumber.isEmpty()) {
            primeSet.add(Integer.parseInt(currentNumber));
        }

        for (int i = 0; i < remainNumbers.length(); i++) {
            bruteforce(
                    currentNumber + remainNumbers.charAt(i),
                    remainNumbers.substring(0, i) + remainNumbers.substring(i + 1),
                    primeSet
            );
        }
    }

}
