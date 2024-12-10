package programmers;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 프로그래머스
 * - 코딩테스트 연습 - 2018 KAKAO BLIND RECRUITMENT - [1차] 캐시 (https://school.programmers.co.kr/learn/courses/30/lessons/17680)
 *
 * 문제 설명
 * - 지도개발팀에서 근무하는 제이지는 지도에서 도시 이름을 검색하면 해당 도시와 관련된 맛집 게시물들을 데이터베이스에서 읽어 보여주는 서비스를 개발하고 있다.
 * 이 프로그램의 테스팅 업무를 담당하고 있는 어피치는 서비스를 오픈하기 전 각 로직에 대한 성능 측정을 수행하였는데,
 * 제이지가 작성한 부분 중 데이터베이스에서 게시물을 가져오는 부분의 실행시간이 너무 오래 걸린다는 것을 알게 되었다.
 * 어피치는 제이지에게 해당 로직을 개선하라고 닦달하기 시작하였고,
 * 제이지는 DB 캐시를 적용하여 성능 개선을 시도하고 있지만 캐시 크기를 얼마로 해야 효율적인지 몰라 난감한 상황이다.
 *
 * 어피치에게 시달리는 제이지를 도와, DB 캐시를 적용할 때 캐시 크기에 따른 실행시간 측정 프로그램을 작성하시오.
 *
 * 입력 형식
 * - 캐시 크기(cacheSize)와 도시이름 배열(cities)을 입력받는다.
 * - cacheSize는 정수이며, 범위는 0 ≦ cacheSize ≦ 30 이다.
 * - cities는 도시 이름으로 이뤄진 문자열 배열로, 최대 도시 수는 100,000개이다.
 * - 각 도시 이름은 공백, 숫자, 특수문자 등이 없는 영문자로 구성되며, 대소문자 구분을 하지 않는다. 도시 이름은 최대 20자로 이루어져 있다.
 */
public class Programmers17680 {

    public static void main(String[] args) {
        final int cacheSize1 = 3;
        final String[] cities1 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        final int cacheSize2 = 3;
        final String[] cities2 = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};

        final int cacheSize3 = 2;
        final String[] cities3 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};

        final int cacheSize4 = 5;
        final String[] cities4 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};

        final int cacheSize5 = 2;
        final String[] cities5 = {"Jeju", "Pangyo", "NewYork", "newyork"};

        final int cacheSize6 = 0;
        final String[] cities6 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        System.out.println(solution(cacheSize1, cities1));
        System.out.println(solution(cacheSize2, cities2));
        System.out.println(solution(cacheSize3, cities3));
        System.out.println(solution(cacheSize4, cities4));
        System.out.println(solution(cacheSize5, cities5));
        System.out.println(solution(cacheSize6, cities6));
    }

    public static int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5;

        // Integer로 카운팅하는 의미가 이 문제에서는 없으니 Boolean으로 메모리 절약도 괜찮은 생각
        final LRUCache<String, Integer> cache = new LRUCache<>(cacheSize);
        int duration = 0;

        for (String city : cities) {
            final String lowerCase = city.toLowerCase();

            final Integer count = cache.get(lowerCase);
            if (count == null) {
                duration += 5;
                // Boolean이라면 아래의 불필요한 연산이 간단해짐
                cache.put(lowerCase, cache.getOrDefault(lowerCase, 0) + 1);
            }
            else {
                duration += 1;
                cache.put(lowerCase, cache.get(lowerCase) + 1);
            }
        }

        return duration;
    }

    static class LRUCache<K, V> extends LinkedHashMap<K, V> {
        private final int cacheSize;

        public LRUCache(final int cacheSize) {
            // 초기 용량, 해시 테이블 크기 조정 임계값(default 0.75), 데이터 정렬 기준 설정(true: 데이터 접근 순서 유지)
            super(cacheSize, 0.75f, true);
            this.cacheSize = cacheSize;
        }

        @Override
        protected boolean removeEldestEntry(final Map.Entry<K, V> eldest) {
            return size() > cacheSize;
        }

    }

}
