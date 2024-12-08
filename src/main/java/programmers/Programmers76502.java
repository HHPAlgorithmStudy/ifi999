package programmers;

import java.util.Stack;

/**
 * 프로그래머스
 * - 코딩테스트 연습 - 월간 코드 챌린지 시즌2 - 괄호 회전하기 (https://school.programmers.co.kr/learn/courses/30/lessons/76502)
 *
 * 문제 설명
 * - 다음 규칙을 지키는 문자열을 올바른 괄호 문자열이라고 정의합니다.
 *
 *      - (), [], {} 는 모두 올바른 괄호 문자열입니다.
 *      - 만약 A가 올바른 괄호 문자열이라면, (A), [A], {A} 도 올바른 괄호 문자열입니다.
 *        예를 들어, [] 가 올바른 괄호 문자열이므로, ([]) 도 올바른 괄호 문자열입니다.
 *      - 만약 A, B가 올바른 괄호 문자열이라면, AB 도 올바른 괄호 문자열입니다.
 *        예를 들어, {} 와 ([]) 가 올바른 괄호 문자열이므로, {}([]) 도 올바른 괄호 문자열입니다.
 *
 * 대괄호, 중괄호, 그리고 소괄호로 이루어진 문자열 s가 매개변수로 주어집니다.
 * 이 s를 왼쪽으로 x (0 ≤ x < (s의 길이)) 칸만큼 회전시켰을 때 s가 올바른 괄호 문자열이 되게 하는 x의 개수를 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * - s의 길이는 1 이상 1,000 이하입니다.
 *
 * 풀이
 * - O(N^2)
 */
public class Programmers76502 {

    public static void main(String[] args) {
        final String s1 = "[](){}";
        final String s2 = "}]()[{";
        final String s3 = "[)(]";
        final String s4 = "}}}";

        System.out.println(solution(s1));
        System.out.println(solution(s2));
        System.out.println(solution(s3));
        System.out.println(solution(s4));
    }

    public static int solution(String s) {
        final int length = s.length();
        final String extendedStr = s + s;
        int answer = 0;

        for (int i = 0; i < length; i++) {
            Stack<Character> stack = new Stack<>();
            boolean isSuccess = true;

            for (int j = i; j < i + length; j++) {
                final char ch = extendedStr.charAt(j);

                if (ch == '(' || ch == '{' || ch == '[') {
                    stack.push(ch);
                } else {
                    // 닫는 괄호가 더 많은 경우
                    if (stack.isEmpty()) {
                        isSuccess = false;
                        break;
                    }

                    final char top = stack.pop();
                    // 짝이 맞지 않는 경우
                    if ((ch == ')' && top != '(')
                            || (ch == '}' && top != '{')
                            || (ch == ']' && top != '[')) {
                        isSuccess = false;
                        break;
                    }
                }
            }

            // 성공 + 스택 비어야함
            if (isSuccess && stack.isEmpty()) {
                answer++;
            }
        }

        return answer;
    }

}
