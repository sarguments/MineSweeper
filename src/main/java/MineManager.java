import java.util.ArrayList;
import java.util.List;

public class MineManager {

    private final List<Integer> numbers;
    private final int rowCount;
    private final List<CalculateStrategy> strategies = new ArrayList<>();

    public MineManager(List<Integer> numbers, int rowCount) {
        this.numbers = numbers;
        this.rowCount = rowCount;

        strategies.add(new LLCalculateStrategy());
        strategies.add(new RRCalculateStrategy());
        strategies.add(new UUCalculateStrategy());
        strategies.add(new DDCalculateStrategy());
    }

    public List<Integer> calcMineNumbers() {
        ArrayList<Integer> result = new ArrayList<>();

        numbers.forEach(
                mineNumber -> strategies.stream().filter(
                        strategy -> strategy.isCalculable(mineNumber, rowCount) && !numbers.contains(strategy.getCalculateNumber(mineNumber))
                ).forEach(filteredStrategy -> calculate(filteredStrategy, mineNumber, result))
        );

        return result;
    }

    public void calculate(CalculateStrategy strategy, int mineNumber, List<Integer> result) {
        if (strategy.isCalculable(mineNumber, rowCount)) {
            result.add(strategy.getCalculateNumber(mineNumber));
        }
    }

    interface CalculateStrategy {
        boolean isCalculable(int mineNumber, int rowCount);

        int getCalculateNumber(int number);
    }

    public static class LLCalculateStrategy implements CalculateStrategy {
        @Override
        public boolean isCalculable(int mineNumber, int rowCount) {
            return mineNumber % rowCount > 0;
        }

        @Override
        public int getCalculateNumber(int number) {
            return number - 1;
        }
    }

    public static class RRCalculateStrategy implements CalculateStrategy {
        @Override
        public boolean isCalculable(int mineNumber, int rowCount) {
            return mineNumber % rowCount < rowCount - 1;
        }

        @Override
        public int getCalculateNumber(int number) {
            return number + 1;
        }
    }

    public static class UUCalculateStrategy implements CalculateStrategy {
        private int rowCount;

        @Override
        public boolean isCalculable(int mineNumber, int rowCount) {
            this.rowCount = rowCount;
            return mineNumber - rowCount >= 0;
        }

        @Override
        public int getCalculateNumber(int number) {
            return number - rowCount;
        }
    }

    public static class DDCalculateStrategy implements CalculateStrategy {
        private int rowCount;

        @Override
        public boolean isCalculable(int mineNumber, int rowCount) {
            this.rowCount = rowCount;
            return mineNumber + rowCount < rowCount * rowCount;
        }

        @Override
        public int getCalculateNumber(int number) {
            return number + rowCount;
        }
    }
}
