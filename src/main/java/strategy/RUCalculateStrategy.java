package strategy;

public class RUCalculateStrategy implements CalculateStrategy {
    private final int rowCount;

    public RUCalculateStrategy(int rowCount) {
        this.rowCount = rowCount;
    }

    @Override
    public boolean isCalculable(int mineNumber) {
        return (mineNumber % rowCount < rowCount - 1) && (mineNumber - rowCount > 0);
    }

    @Override
    public int getCalculateNumber(int number) {
        return number - (rowCount - 1);
    }
}
