package programmers;

import java.util.Stack;

/**
 * 프로그래머스
 * - 코딩테스트 연습 - 연습문제 - 올바른 괄호 (https://school.programmers.co.kr/learn/courses/30/lessons/12909)
 *
 * 문제 설명
 * - 괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다.
 * 예를 들어
 *
 *      "()()" 또는 "(())()" 는 올바른 괄호입니다.
 *      ")()(" 또는 "(()(" 는 올바르지 않은 괄호입니다.
 *
 * '(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고,
 * 올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.
 *
 * 제한사항
 * - 문자열 s의 길이 : 100,000 이하의 자연수
 * - 문자열 s는 '(' 또는 ')' 로만 이루어져 있습니다.
 *
 * 풀이
 * - 순회, 스택
 * - 시간복잡도: O(N)
 */
public class Programmers12909 {

    public static void main(String[] args) {
        final String s1 = "()()";
        final String s2 = "(())()";
        final String s3 = ")()(";
        final String s4 = "(()(";

        System.out.println(solution2(s1));
        System.out.println(solution2(s2));
        System.out.println(solution2(s3));
        System.out.println(solution2(s4));
    }

    /*
     * 효율성 실패
     * 1) Stack은 내부적으로 동기화 처리가 포함되어 있어 성능이 떨어질 수 있음
     * -> int count 사용
     * 
     * 2) split 제거
     * -> charAt 사용
     */
    static boolean solution(String s) {
        final String[] arr = s.split("");
        final Stack<String> stack = new Stack<>();

        for (String str : arr) {
            if (stack.isEmpty() && str.equals(")")) return false;

            if (str.equals("(")) stack.push(str);
            else {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    // 통과
    static boolean solution2(String s) {
        final int length = s.length();
        int count = 0;

        for (int i = 0; i < length; i++) {
            final char ch = s.charAt(i);

            if (ch == '(') count++;
            else {
                count--;
                if (count < 0) return false;
            }
        }

        return count == 0;
    }

}
