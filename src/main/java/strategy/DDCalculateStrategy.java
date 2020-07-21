package strategy;

public class DDCalculateStrategy implements CalculateStrategy {
    private final int rowCount;

    public DDCalculateStrategy(int rowCount) {
        this.rowCount = rowCount;
    }

    @Override
    public boolean isCalculable(int mineNumber) {
        return mineNumber + rowCount < rowCount * rowCount;
    }

    @Override
    public int getCalculateNumber(int number) {
        return number + rowCount;
    }
}
