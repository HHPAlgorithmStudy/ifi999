package programmers;

/**
 * 프로그래머스
 * - 코딩테스트 연습 - 월간 코드 챌린지 시즌1 - 이진 변환 반복하기 (https://school.programmers.co.kr/learn/courses/30/lessons/70129)
 *
 * 문제 설명
 * - 0과 1로 이루어진 어떤 문자열 x에 대한 이진 변환을 다음과 같이 정의합니다.
 *
 *      1. x의 모든 0을 제거합니다.
 *      2. x의 길이를 c라고 하면, x를 "c를 2진법으로 표현한 문자열"로 바꿉니다.
 *
 * 예를 들어, x = "0111010"이라면, x에 이진 변환을 가하면 x = "0111010" -> "1111" -> "100" 이 됩니다.
 * 0과 1로 이루어진 문자열 s가 매개변수로 주어집니다.
 * s가 "1"이 될 때까지 계속해서 s에 이진 변환을 가했을 때, 이진 변환의 횟수와 변환 과정에서 제거된 모든 0의 개수를 각각 배열에 담아 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * - s의 길이는 1 이상 150,000 이하입니다.
 * - s에는 '1'이 최소 하나 이상 포함되어 있습니다.
 *
 * 풀이
 */
public class Programmers70129 {

    static int recursionCount;
    static int removeCount;

    public static void main(String[] args) {
        final String s1 = "110010101001";
        final String s2 = "01110";
        final String s3 = "1111111";

        for (int i : solution2(s1)) {
            System.out.println(i);
        }

        System.out.println("=====");

        for (int i : solution2(s2)) {
            System.out.println(i);
        }

        System.out.println("=====");

        for (int i : solution2(s3)) {
            System.out.println(i);
        }
    }

    public static int[] solution(String s) {
        recursionCount = 0; // 이진 변환 횟수
        removeCount = 0; // 제거된 0 개수

        recursion(s);

        return new int[]{recursionCount, removeCount};
    }

    public static void recursion(String s) {
        if (s.equals("1")) return;

        final StringBuilder sb = new StringBuilder();

        recursionCount++;
        final int length = s.length();
        for (int i = 0; i < length; i++) {
            final char ch = s.charAt(i);
            if (ch == '0') removeCount++;
            else if (ch == '1') sb.append(ch);
        }

        final String removedStr = sb.toString();
        final int removedLength = removedStr.length();
        final String binaryString = Integer.toBinaryString(removedLength);

        recursion(binaryString);
    }

    // 효율성 개선
    public static int[] solution2(String s) {
        int recursionCnt = 0;
        int removeCnt = 0;

        while (!s.equals("1")) {
            recursionCnt++;

            final int length = s.length();

            int oneCount = 0;
            for (char c : s.toCharArray()) {
                if (c == '1') oneCount++;
            }

            removeCnt += (length - oneCount);

            s = Integer.toBinaryString(oneCount);
        }

        return new int[]{recursionCnt, removeCnt};
    }

}
