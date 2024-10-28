package programmers;

import java.time.Duration;

/**
 * 프로그래머스
 * - 코딩테스트 연습 - PCCP기출문제 - 동영상 재생기 (https://school.programmers.co.kr/learn/courses/30/lessons/340213)
 *
 * 문제 설명
 * - 당신은 동영상 재생기를 만들고 있습니다.
 * 당신의 동영상 재생기는 10초 전으로 이동, 10초 후로 이동, 오프닝 건너뛰기 3가지 기능을 지원합니다.
 * 각 기능이 수행하는 작업은 다음과 같습니다.
 *
 *      - 10초 전으로 이동: 사용자가 "prev" 명령을 입력할 경우 동영상의 재생 위치를 현재 위치에서 10초 전으로 이동합니다.
 *        현재 위치가 10초 미만인 경우 영상의 처음 위치로 이동합니다. 영상의 처음 위치는 0분 0초입니다.
 *      - 10초 후로 이동: 사용자가 "next" 명령을 입력할 경우 동영상의 재생 위치를 현재 위치에서 10초 후로 이동합니다.
 *        동영상의 남은 시간이 10초 미만일 경우 영상의 마지막 위치로 이동합니다. 영상의 마지막 위치는 동영상의 길이와 같습니다.
 *      - 오프닝 건너뛰기: 현재 재생 위치가 오프닝 구간(op_start ≤ 현재 재생 위치 ≤ op_end)인 경우 자동으로 오프닝이 끝나는 위치로 이동합니다.
 *
 * 동영상의 길이를 나타내는 문자열 video_len, 기능이 수행되기 직전의 재생위치를 나타내는 문자열 pos,
 * 오프닝 시작 시각을 나타내는 문자열 op_start, 오프닝이 끝나는 시각을 나타내는 문자열 op_end,
 * 사용자의 입력을 나타내는 1차원 문자열 배열 commands가 매개변수로 주어집니다.
 * 이때 사용자의 입력이 모두 끝난 후 동영상의 위치를 "mm:ss" 형식으로 return 하도록 solution 함수를 완성해 주세요.
 *
 * 제한사항
 *  - video_len의 길이 = pos의 길이 = op_start의 길이 = op_end의 길이 = 5
 *      - video_len, pos, op_start, op_end는 "mm:ss" 형식으로 mm분 ss초를 나타냅니다.
 *      - 0 ≤ mm ≤ 59
 *      - 0 ≤ ss ≤ 59
 *      - 분, 초가 한 자리일 경우 0을 붙여 두 자리로 나타냅니다.
 *      - 비디오의 현재 위치 혹은 오프닝이 끝나는 시각이 동영상의 범위 밖인 경우는 주어지지 않습니다.
 *      - 오프닝이 시작하는 시각은 항상 오프닝이 끝나는 시각보다 전입니다.
 *  - 1 ≤ commands의 길이 ≤ 100
 *      - commands의 원소는 "prev" 혹은 "next"입니다.
 *      - "prev"는 10초 전으로 이동하는 명령입니다.
 *      - "next"는 10초 후로 이동하는 명령입니다.
 *
 * 풀이
 * - 순회 : O(N)
 */
public class Programmers340213 {

    public static void main(String[] args) {
        final String video_len1 = "34:33";
        final String pos1 = "13:00";
        final String op_start1 = "00:55";
        final String op_end1 = "02:55";
        final String[] commands1 = {"next", "prev"};

        final String video_len2 = "10:55";
        final String pos2 = "00:05";
        final String op_start2 = "00:15";
        final String op_end2 = "06:55";
        final String[] commands2 = {"prev", "next", "next"};

        final String video_len3 = "07:22";
        final String pos3 = "04:05";
        final String op_start3 = "00:15";
        final String op_end3 = "04:07";
        final String[] commands3 = {"next"};

        final String result1 = solution(video_len1, pos1, op_start1, op_end1, commands1);
        final String result2 = solution(video_len2, pos2, op_start2, op_end2, commands2);
        final String result3 = solution(video_len3, pos3, op_start3, op_end3, commands3);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

    public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        final Duration videoLen = parseDuration(video_len);
        Duration position = parseDuration(pos);
        final Duration opStart = parseDuration(op_start);
        final Duration opEnd = parseDuration(op_end);

        for (String command : commands) {
            if (isOpening(position, opStart, opEnd)) position = opEnd;

            switch (command) {
                case "next":
                    position = position.plusSeconds(10);
                    if (position.compareTo(videoLen) > 0) position = videoLen;
                    break;
                case "prev":
                    position = position.minusSeconds(10);
                    if (position.isNegative()) position = Duration.ZERO;
                    break;
                default:
                    break;
            }
        }

        if (isOpening(position, opStart, opEnd)) position = opEnd;

        return formatDuration(position);
    }

    private static boolean isOpening(final Duration pos, final Duration opStart, final Duration opEnd) {
        return !pos.minus(opStart).isNegative() && pos.minus(opEnd).isNegative();
    }

    private static Duration parseDuration(String time) {
        String[] parts = time.split(":");
        long minutes = Long.parseLong(parts[0]);
        long seconds = Long.parseLong(parts[1]);
        return Duration.ofMinutes(minutes).plusSeconds(seconds);
    }

    private static String formatDuration(Duration duration) {
        long minutes = duration.toMinutes();
        long seconds = duration.minusMinutes(minutes).getSeconds();
        return String.format("%02d:%02d", minutes, seconds);
    }

}
