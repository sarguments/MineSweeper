package strategy;

public class RDCalculateStrategy implements CalculateStrategy {
    private final int rowCount;

    public RDCalculateStrategy(int rowCount) {
        this.rowCount = rowCount;
    }

    @Override
    public boolean isCalculable(int mineNumber) {
        return (mineNumber % rowCount < rowCount - 1) && (mineNumber + rowCount < rowCount * rowCount);
    }

    @Override
    public int getCalculateNumber(int number) {
        return number + (rowCount + 1);
    }
}
