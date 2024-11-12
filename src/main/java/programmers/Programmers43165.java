package programmers;

/**
 * 프로그래머스
 * - 코딩테스트 연습 - DFS/BFS - 타겟 넘버 (https://school.programmers.co.kr/learn/courses/30/lessons/43165)
 *
 * 문제 설명
 * - n개의 음이 아닌 정수들이 있습니다.
 * 이 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다.
 * 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.
 *
 *      -1+1+1+1+1 = 3
 *      +1-1+1+1+1 = 3
 *      +1+1-1+1+1 = 3
 *      +1+1+1-1+1 = 3
 *      +1+1+1+1-1 = 3
 *
 * 사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때
 * 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * - 주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
 * - 각 숫자는 1 이상 50 이하인 자연수입니다.
 * - 타겟 넘버는 1 이상 1000 이하인 자연수입니다.
 *
 * 풀이
 * - DFS : O(2^N) (N: numbers의 길이)
 */
public class Programmers43165 {

    private static int answer;

    public static void main(String[] args) {
        final int[] numbers1 = {1, 1, 1, 1, 1};
        final int target1 = 3;

        final int[] numbers2 = {4, 1, 2, 1};
        final int target2 = 4;

        System.out.println(solution(numbers1, target1));
        System.out.println(solution(numbers2, target2));
    }

    public static int solution(int[] numbers, int target) {
        answer = 0;

        dfs(numbers, target, 0, 0);

        return answer;
    }

    public static void dfs(int[] numbers, int target, int depth, int sum) {
        if (depth == numbers.length) {
            if (sum == target) answer++;

            return;
        }

        dfs(numbers, target, depth + 1, sum + numbers[depth]);
        dfs(numbers, target, depth + 1, sum - numbers[depth]);
    }

}
