package strategy;

public class RRCalculateStrategy implements CalculateStrategy {
    private final int rowCount;

    public RRCalculateStrategy(int rowCount) {
        this.rowCount = rowCount;
    }

    @Override
    public boolean isCalculable(int mineNumber) {
        return mineNumber % rowCount < rowCount - 1;
    }

    @Override
    public int getCalculateNumber(int number) {
        return number + 1;
    }
}