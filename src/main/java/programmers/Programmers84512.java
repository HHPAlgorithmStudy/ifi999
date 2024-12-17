package programmers;

/**
 * 프로그래머스
 * - 코딩테스트 연습 - 완전탐색 - 모음사전 (https://school.programmers.co.kr/learn/courses/30/lessons/84512)
 *
 * 문제 설명
 * - 사전에 알파벳 모음 'A', 'E', 'I', 'O', 'U'만을 사용하여 만들 수 있는, 길이 5 이하의 모든 단어가 수록되어 있습니다.
 * 사전에서 첫 번째 단어는 "A"이고, 그다음은 "AA"이며, 마지막 단어는 "UUUUU"입니다.
 * 단어 하나 word가 매개변수로 주어질 때, 이 단어가 사전에서 몇 번째 단어인지 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * - word의 길이는 1 이상 5 이하입니다.
 * - word는 알파벳 대문자 'A', 'E', 'I', 'O', 'U'로만 이루어져 있습니다.
 *
 * 풀이
 * -
 */
public class Programmers84512 {

    /*
     * 1. UUUUU =
     *      5^0 * 5 +
     *      5^1 * 5 +
     *      5^2 * 5 +
     *      5^3 * 5 +
     *      5^4 * 5
     *
     * 2. IIIII =
     *      5^0 * 3 +
     *      5^1 * 3 +
     *      5^2 * 3 +
     *      5^3 * 3 +
     *      5^4 * 3
     */
    public static void main(String[] args) {
        final String word1 = "AAAAE";
        final String word2 = "AAAE";
        final String word3 = "I";
        final String word4 = "EIO";

        System.out.println(solution(word1));
    }

    public static int solution(String word) {
        final int[] weights = {781, 156, 31, 6, 1}; // 가중치
        final char[] vowels = {'A', 'E', 'I', 'O', 'U'};
        int answer = 0;

        for (int i = 0; i < word.length(); i++) {
            final char ch = word.charAt(i);

            for (int j = 0; j < vowels.length; j++) {
                if (ch == vowels[j]) {
                    answer += weights[i] * j + 1; // 가중치 * 인덱스 + 1
                    break;
                }
            }
        }

        return answer;
    }

}
