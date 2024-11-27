package programmers;

/**
 * 프로그래머스
 * - 코딩테스트 연습 - 연습문제 - 숫자의 표현 (https://school.programmers.co.kr/learn/courses/30/lessons/12924)
 *
 * 문제 설명
 * - Finn은 요즘 수학공부에 빠져 있습니다.
 * 수학 공부를 하던 Finn은 자연수 n을 연속한 자연수들로 표현 하는 방법이 여러개라는 사실을 알게 되었습니다.
 * 예를들어 15는 다음과 같이 4가지로 표현 할 수 있습니다.
 *
 *      - 1 + 2 + 3 + 4 + 5 = 15
 *      - 4 + 5 + 6 = 15
 *      - 7 + 8 = 15
 *      - 15 = 15
 *
 * 자연수 n이 매개변수로 주어질 때, 연속된 자연수들로 n을 표현하는 방법의 수를 return하는 solution를 완성해주세요.
 *
 * 제한사항
 * - n은 10,000 이하의 자연수 입니다.
 *
 * 풀이
 * - 기존 : O(N^2)
 * - 등차수열 합공식 활용 : O(sqrt(2N))
 */
public class Programmers12924 {

    public static void main(String[] args) {
        final int n = 15;

        System.out.println(solution(n));
        System.out.println(solution2(n));
    }

    public static int solution(int n) {
        final int length = n / 2;
        int answer = 0;

        for (int i = 1; i <= length; i++) {

            int tmp = i;
            for (int j = i + 1; j <= length + 1; j++) {
                if (tmp >= n) break;
                tmp += j;
            }

            if (tmp == n) answer++;
        }

        // n = n 인 경우 + 1
        return answer + 1;
    }

    // 등차수열 합 공식 활용
    public static int solution2(int n) {
        int count = 0;

        // k: 연속된 수의 개수 (1부터 시작)
        for (int k = 1; k * (k - 1) / 2 < n; k++) {
            // 2n에서 k * (k-1)을 뺀 값이 k로 나누어떨어지면 연속된 수 합 가능
            if ((n - k * (k - 1) / 2) % k == 0) {
                count++;
            }
        }

        return count;
    }

}
