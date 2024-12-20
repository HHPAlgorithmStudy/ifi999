package programmers;

import java.util.Arrays;
import java.util.Stack;

/**
 * 프로그래머스
 * - 코딩테스트 연습 - 연습문제 - 뒤에 있는 큰 수 찾기 (https://school.programmers.co.kr/learn/courses/30/lessons/154539)
 *
 * 문제 설명
 * - 정수로 이루어진 배열 numbers가 있습니다. 배열 의 각 원소들에 대해 자신보다 뒤에 있는 숫자 중에서 자신보다 크면서 가장 가까이 있는 수를 뒷 큰수라고 합니다.
 * 정수 배열 numbers가 매개변수로 주어질 때, 모든 원소에 대한 뒷 큰수들을 차례로 담은 배열을 return 하도록 solution 함수를 완성해주세요. 단, 뒷 큰수가 존재하지 않는 원소는 -1을 담습니다.
 *
 * 제한사항
 * - 4 ≤ numbers의 길이 ≤ 1,000,000
 *      - 1 ≤ numbers[i] ≤ 1,000,000
 *
 * 풀이
 * - O(N)
 */
public class Programmers154539 {

    public static void main(String[] args) {
        final int[] numbers1 = {2, 3, 3, 5};
        final int[] numbers2 = {9, 1, 5, 3, 6, 2};

        System.out.println(Arrays.toString(solution(numbers1)));
        System.out.println(Arrays.toString(solution(numbers2)));
    }

    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        final Stack<Integer> stack = new Stack<>();

        for (int i = numbers.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= numbers[i]) {
                stack.pop();
            }

            answer[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(numbers[i]);
        }

        return answer;
    }

}
