package programmers;

/**
 * 프로그래머스
 * - 코딩테스트 연습 - 연습문제 - 피보나치수 (https://school.programmers.co.kr/learn/courses/30/lessons/12945)
 *
 * 문제 설명
 * - 피보나치 수는 F(0) = 0, F(1) = 1일 때, 1 이상의 n에 대하여 F(n) = F(n-1) + F(n-2) 가 적용되는 수 입니다.
 * 예를들어
 *
 *      - F(2) = F(0) + F(1) = 0 + 1 = 1
 *      - F(3) = F(1) + F(2) = 1 + 1 = 2
 *      - F(4) = F(2) + F(3) = 1 + 2 = 3
 *      - F(5) = F(3) + F(4) = 2 + 3 = 5
 *
 * 와 같이 이어집니다.
 * 2 이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴하는 함수, solution을 완성해 주세요.
 *
 * 제한 사항
 * - n은 2 이상 100,000 이하인 자연수입니다.
 *
 * 풀이
 * - 풀이1: 시간복잡도 O(N^2)
 * - 풀이2: 시간복잡도 O(N), 공간복잡도 O(N)
 * - 풀이3: 시간복잡도 O(N), 공간복잡도 O(1)
 */
public class Programmers12945 {

    public static void main(String[] args) {
        final int n1 = 3;
        final int n2 = 5;

        System.out.println(solution3(n1));
        System.out.println(solution3(n2));
    }

    // 효율성 X
    public static int solution(int n) {
        return fibonacci(n) % 1234567;
    }

    public static int fibonacci(int n) {
        if (n < 2) {
            return n;
        }

        return fibonacci(n -1) + fibonacci(n -2);
    }

    // 테스트케이스 일부 실패
    public static int solution2(int n) {
        final int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2] % 1234567;
        }

        return fib[n];
    }

    public static int solution3(int n) {
        int prev1 = 0;
        int prev2 = 1;

        for (int i = 2; i <= n; i++) {
            int curr = (prev1 + prev2) % 1234567;
            prev1 = prev2;
            prev2 = curr;
        }

        return prev2;
    }

}
