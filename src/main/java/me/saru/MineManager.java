package me.saru;

import me.saru.strategy.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 지뢰가 있는 박스 번호로 부터 주위 8방향에 해당하는 박스 인덱스를 구한다.
 */
public class MineManager {

    private final List<Integer> numbers;
    private final List<CalculateStrategy> strategies = new ArrayList<>();

    // 8방향에 대한 각각의 패턴을 추가한다.
    public MineManager(List<Integer> numbers, int rowCount) {
        this.numbers = numbers;

        strategies.add(new LLCalculateStrategy(rowCount));
        strategies.add(new RRCalculateStrategy(rowCount));
        strategies.add(new UUCalculateStrategy(rowCount));
        strategies.add(new DDCalculateStrategy(rowCount));

        strategies.add(new LUCalculateStrategy(rowCount));
        strategies.add(new RUCalculateStrategy(rowCount));
        strategies.add(new LDCalculateStrategy(rowCount));
        strategies.add(new RDCalculateStrategy(rowCount));
    }

    // 지뢰 카운트를 증가시킬 박스 인덱스를 구한다.
    public List<Integer> calcMineNumbers() {
        List<Integer> result = new ArrayList<>();

        // 리스트에 중복 숫자가 들어와도 해쉬셋 변환 시 중복 제거됨
        Set<Integer> collect = new HashSet<>(numbers);

        // 지뢰 인덱스에 대해 '해당 전략으로 이동이 가능한지' 를 만족하는 전략들을 필터링 해서 증가시킬 박스 인덱스를 구한다.
        collect.forEach(
                mineNumber -> strategies.stream().filter(
                        strategy -> strategy.isPassable(mineNumber)
                ).forEach(filteredStrategy -> calculate(filteredStrategy, mineNumber, result)));

        return result;
    }

    // 선택된 로직에 유효한 경우 그에 해당하는 박스 인덱스를 결과 리스트에 추가한다. 해당 인덱스에 지뢰가 이미 있는 경우는 제외한다.
    public void calculate(CalculateStrategy strategy, int mineNumber, List<Integer> result) {
        int calculateNumber = strategy.getCalculateNumber(mineNumber);

        if (strategy.isPassable(mineNumber) && !numbers.contains(calculateNumber)) {
            result.add(calculateNumber);
        }
    }

}
