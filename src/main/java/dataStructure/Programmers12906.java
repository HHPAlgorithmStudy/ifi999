package dataStructure;

import java.util.*;

/**
 * 프로그래머스
 * - 코딩테스트 연습 - 스택/큐 - 같은 숫자는 싫어 (https://school.programmers.co.kr/learn/courses/30/lessons/12906)
 *
 * 문제 설명
 * - 배열 arr가 주어집니다. 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다.
 * 이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다.
 * 단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다.
 * 예를 들면,
 *
 *      arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return 합니다.
 *      arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return 합니다.
 *
 * 배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요.
 *
 * 제한사항
 *  배열 arr의 크기 : 1,000,000 이하의 자연수
 *  배열 arr의 원소의 크기 : 0보다 크거나 같고 9보다 작거나 같은 정수
 *
 * 풀이
 * - 스택에 넣고 peek 대조로 push : O(N)
 */
public class Programmers12906 {

    public static void main(String[] args) {
        final int[] arr1 = {1,1,3,3,0,1,1};
        final int[] arr2 = {4,4,4,3,3};

        final int[] result1 = solution(arr1);
        final int[] result2 = solution(arr2);

        for (int i : result1) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i : result2) {
            System.out.print(i + " ");
        }
    }

    public static int[] solution(int[] arr) {
        final Stack<Integer> stack = new Stack<>();
        for (Integer i : arr) {
            if (stack.isEmpty() || stack.peek() != i) {
                stack.push(i);
            }
        }

        final int size = stack.size();
        final int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[size -1 -i] = stack.pop();
        }

        return result;
    }

}
