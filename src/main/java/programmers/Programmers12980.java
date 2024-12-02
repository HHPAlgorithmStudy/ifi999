package programmers;

/**
 * 프로그래머스
 * - 코딩테스트 연습 - Summer/Winter Coding(~2018) - 점프와 순간 이동 (https://school.programmers.co.kr/learn/courses/30/lessons/12980)
 *
 * 문제 설명
 * - OO 연구소는 한 번에 K 칸을 앞으로 점프하거나, (현재까지 온 거리) x 2 에 해당하는 위치로 순간이동을 할 수 있는 특수한 기능을 가진 아이언 슈트를 개발하여 판매하고 있습니다.
 * 이 아이언 슈트는 건전지로 작동되는데, 순간이동을 하면 건전지 사용량이 줄지 않지만, 앞으로 K 칸을 점프하면 K 만큼의 건전지 사용량이 듭니다.
 * 그러므로 아이언 슈트를 착용하고 이동할 때는 순간 이동을 하는 것이 더 효율적입니다. 아이언 슈트 구매자는 아이언 슈트를 착용하고 거리가 N 만큼 떨어져 있는 장소로 가려고 합니다.
 * 단, 건전지 사용량을 줄이기 위해 점프로 이동하는 것은 최소로 하려고 합니다.
 * 아이언 슈트 구매자가 이동하려는 거리 N이 주어졌을 때, 사용해야 하는 건전지 사용량의 최솟값을 return하는 solution 함수를 만들어 주세요.
 *
 * 예를 들어 거리가 5만큼 떨어져 있는 장소로 가려고 합니다.
 * 아이언 슈트를 입고 거리가 5만큼 떨어져 있는 장소로 갈 수 있는 경우의 수는 여러 가지입니다.
 *
 *      - 처음 위치 0 에서 5 칸을 앞으로 점프하면 바로 도착하지만, 건전지 사용량이 5 만큼 듭니다.
 *      - 처음 위치 0 에서 2 칸을 앞으로 점프한 다음 순간이동 하면 (현재까지 온 거리 : 2) x 2에 해당하는 위치로 이동할 수 있으므로 위치 4로 이동합니다.
 *        이때 1 칸을 앞으로 점프하면 도착하므로 건전지 사용량이 3 만큼 듭니다.
 *      - 처음 위치 0 에서 1 칸을 앞으로 점프한 다음 순간이동 하면 (현재까지 온 거리 : 1) x 2에 해당하는 위치로 이동할 수 있으므로 위치 2로 이동됩니다.
 *        이때 다시 순간이동 하면 (현재까지 온 거리 : 2) x 2 만큼 이동할 수 있으므로 위치 4로 이동합니다. 이때 1 칸을 앞으로 점프하면 도착하므로 건전지 사용량이 2 만큼 듭니다.
 *
 * 위의 3가지 경우 거리가 5만큼 떨어져 있는 장소로 가기 위해서 3번째 경우가 건전지 사용량이 가장 적으므로 답은 2가 됩니다.
 *
 * 제한 사항
 * - 숫자 N: 1 이상 10억 이하의 자연수
 * - 숫자 K: 1 이상의 자연수
 *
 * 풀이
 * - O(logN)
 * - 사실상 해당 값을 이진수로 변환하고, 거기서 '1'개수를 세는 문제
 */
public class Programmers12980 {

    public static void main(String[] args) {
        final int n1 = 5;
        final int n2 = 6;
        final int n3 = 5000;

        System.out.println(solution2(n1));
        System.out.println(solution2(n2));
        System.out.println(solution2(n3));
    }

    public static int solution(int n) {
        int ans = 0;
        final String binaryString = Integer.toBinaryString(n); // O(logN)
        for (char c : binaryString.toCharArray()) { // O(logN)개 순회
            if (c == '1') ans++;
        }

        return ans;
    }

    // 기존 풀이가 애초에 method로 있음
    public static int solution2(int n) {
        return Integer.bitCount(n);
    }

}
