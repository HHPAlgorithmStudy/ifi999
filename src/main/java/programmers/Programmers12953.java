package programmers;

/**
 * 프로그래머스
 * - 코딩테스트 연습 - 연습문제 - N개의 최소공배수 (https://school.programmers.co.kr/learn/courses/30/lessons/12953)
 *
 * 문제 설명
 * - 두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다.
 * 예를 들어 2와 7의 최소공배수는 14가 됩니다. 정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다.
 * n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.
 *
 * 제한 사항
 * - arr은 길이 1이상, 15이하인 배열입니다.
 * - arr의 원소는 100 이하인 자연수입니다.
 *
 * 풀이
 * - 유클리드 호제법 (gcd)
 * -> O(log(min(a,b)))
 */
public class Programmers12953 {

    public static void main(String[] args) {
        final int[] arr1 = {2,6,8,14};
        final int[] arr2 = {1,2,3};

        System.out.println(solution(arr1));
        System.out.println(solution(arr2));
    }

    public static int solution(int[] arr) {
        int lcm = arr[0];

        for (int i = 1; i < arr.length; i++) {
            lcm = lcm(lcm, arr[i]);
        }

        return lcm;
    }

    // 최대공약수(GCD) 구하기 - 유클리드 호제법
    public static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }

        return a;
    }

    // 최소공배수(LCM) 구하기
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

}
