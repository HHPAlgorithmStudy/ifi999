package programmers;

import java.util.Arrays;

/**
 * 프로그래머스
 * - 코딩테스트 연습 - PCCP기출문제 - 제출 내역 (https://school.programmers.co.kr/learn/courses/30/lessons/340198)
 *
 * 문제 설명
 * - 지민이는 다양한 크기의 정사각형 모양 돗자리를 가지고 공원에 소풍을 나왔습니다.
 * 공원에는 이미 돗자리를 깔고 여가를 즐기는 사람들이 많아 지민이가 깔 수 있는 가장 큰 돗자리가 어떤 건지 확인하려 합니다.
 * 예를 들어 지민이가 가지고 있는 돗자리의 한 변 길이가 5, 3, 2 세 종류이고, 사람들이 다음과 같이 앉아 있다면 지민이가 깔 수 있는 가장 큰 돗자리는 3x3 크기입니다.
 *
 * 지민이가 가진 돗자리들의 한 변의 길이들이 담긴 정수 리스트 mats, 현재 공원의 자리 배치도를 의미하는 2차원 문자열 리스트 park가 주어질 때
 * 지민이가 깔 수 있는 가장 큰 돗자리의 한 변 길이를 return 하도록 solution 함수를 완성해 주세요.
 * 아무런 돗자리도 깔 수 없는 경우 -1을 return합니다.
 *
 * 제한사항
 * - 1 ≤ mats의 길이 ≤ 10
 *      - 1 ≤ mats의 원소 ≤ 20
 *      - mats는 중복된 원소를 가지지 않습니다.
 * - 1 ≤ park의 길이 ≤ 50
 *       - 1 ≤ park[i]의 길이 ≤ 50
 *       - park[i][j]의 원소는 문자열입니다.
 *       - park[i][j]에 돗자리를 깐 사람이 없다면 "-1", 사람이 있다면 알파벳 한 글자로 된 값을 갖습니다.
 *
 * 풀이
 * -
 */
public class Programmers340198 {

    public static void main(String[] args) {
        final int[] mats = {5, 3, 2};
        final String[][] park = {
                {"A",   "A",    "-1",   "B",    "B",    "B",    "B",    "-1"},
                {"A",   "A",    "-1",   "B",    "B",    "B",    "B",    "-1"},
                {"-1",  "-1",   "-1",   "-1",   "-1",   "-1",   "-1",   "-1"},
                {"D",   "D",    "-1",   "-1",   "-1",   "-1",   "E",    "-1"},
                {"D",   "D",    "-1",   "-1",   "-1",   "-1",   "-1",   "F"},
                {"D",   "D",    "-1",   "-1",   "-1",   "-1",   "E",    "-1"}
        };
        System.out.println(solution(mats, park));
    }

    public static int solution(int[] mats, String[][] park) {
        int answer = -1;
        Arrays.sort(mats); // 크기순 정렬

        for (int m = mats.length - 1; m >= 0; m--) { // 큰 순서대로
            int size = mats[m];

            for (int i = 0; i <= park.length - size; i++) { // 위치 + 돗자리 크기
                for (int j = 0; j <= park[i].length - size; j++) { // 위치 + 돗자리 크기

                    boolean flag = true;
                    for (int x = i; x < i + size; x++) { // 현재 위치에서 돗자리 사이즈까지
                        for (int y = j; y < j + size; y++) { // 현재 위치에서 돗자리 사이즈 까지
                            if (!park[x][y].equals("-1")) { // -1이 아닌 값이 존재하면 넘김
                                flag = false;
                                break;
                            }
                        }

                        if (!flag) break;
                    }

                    if (flag) return size;
                }
            }

        }

        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length; j++) {
                for (int k = 0; k < mats.length; k++) {
                    if (i + mats[k] - 1 > park.length || j + mats[k] - 1 > park[i].length) continue;


                }
            }
        }

        return answer;
    }

}
