package strategy;

public class LDCalculateStrategy implements CalculateStrategy {
    private int rowCount;

    public LDCalculateStrategy(int rowCount) {
        this.rowCount = rowCount;
    }

    @Override
    public boolean isCalculable(int mineNumber) {
        return (mineNumber % rowCount > 0) && (mineNumber + rowCount < rowCount * rowCount);
    }

    @Override
    public int getCalculateNumber(int number) {
        return number + (rowCount - 1);
    }
}
