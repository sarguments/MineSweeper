import strategy.*;

import java.util.ArrayList;
import java.util.List;

public class MineManager {

    private final List<Integer> numbers;
    private final List<CalculateStrategy> strategies = new ArrayList<>();

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

    public List<Integer> calcMineNumbers() {
        ArrayList<Integer> result = new ArrayList<>();

        numbers.forEach(
                mineNumber -> strategies.stream().filter(
                        strategy -> strategy.isPassable(mineNumber) && !numbers.contains(strategy.getCalculateNumber(mineNumber))
                ).forEach(filteredStrategy -> calculate(filteredStrategy, mineNumber, result))
        );

        return result;
    }

    public void calculate(CalculateStrategy strategy, int mineNumber, List<Integer> result) {
        if (strategy.isPassable(mineNumber)) {
            result.add(strategy.getCalculateNumber(mineNumber));
        }
    }

}
