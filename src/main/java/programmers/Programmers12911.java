package programmers;

/**
 * 프로그래머스
 * - 코딩테스트 연습 - 연습문제 - 다음 큰 숫자 (https://school.programmers.co.kr/learn/courses/30/lessons/12911)
 *
 * 문제 설명
 * - 자연수 n이 주어졌을 때, n의 다음 큰 숫자는 다음과 같이 정의 합니다.
 *
 *      - 조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
 *      - 조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
 *      - 조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.
 *
 * 예를 들어서 78(1001110)의 다음 큰 숫자는 83(1010011)입니다.
 * 자연수 n이 매개변수로 주어질 때, n의 다음 큰 숫자를 return 하는 solution 함수를 완성해주세요.
 *
 * 제한 사항
 * - n은 1,000,000 이하의 자연수 입니다.
 *
 * 풀이
 * - O(N)
 * - Integer.toBinaryString(n)을 사용한 방법 -> 효율성 검증 실패
 * - Integer.bitCount(n) : 숫자의 이진 표현에서 1의 개수를 반환
 */
public class Programmers12911 {

    public static void main(String[] args) {
        final int n1 = 78;
        final int n2 = 15;

        System.out.println(solution(n1));
        System.out.println(solution(n2));
    }

    public static  int solution(int n) {
        final int oneCounts = Integer.bitCount(n);

        for (int i = n + 1; i <= 1000000; i++) {
            final int nextOneCounts = Integer.bitCount(i);
            if (oneCounts == nextOneCounts) return i;
        }

        return n;
    }

}
