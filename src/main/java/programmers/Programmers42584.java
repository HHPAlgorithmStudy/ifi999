package programmers;

import java.util.Stack;

/**
 * 프로그래머스
 * - 코딩테스트 연습 - 스택/큐 - 주식가격 (https://school.programmers.co.kr/learn/courses/30/lessons/42584)
 *
 * 문제 설명
 * - 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.
 *
 * 제한사항
 * - prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
 * - prices의 길이는 2 이상 100,000 이하입니다.
 *
 * 풀이
 * - 스택
 * - 시간복잡도: O(N)
 */
public class Programmers42584 {

    public static void main(String[] args) {
        final int[] prices = {1, 2, 3, 2, 3};

        for (int i : solution(prices)) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] prices) {
        final int n = prices.length;
        final int[] answer = new int[n];
        final Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // 현재 가격이 스택에 있는 가격보다 작다면 가격 하락 처리
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                final int idx = stack.pop();
                answer[idx] = i - idx; // 현재 시점에서 가격 하락 시점까지 시간 계산
            }

            stack.push(i); // 현재 인덱스를 스택에 추가
        }

        // 스택에 남아 있는 인덱스 처리 (끝까지 가격이 떨어지지 않은 경우)
        while (!stack.isEmpty()) {
            final int idx = stack.pop();
            answer[idx] = n - idx - 1;
        }

        return answer;
    }

}
