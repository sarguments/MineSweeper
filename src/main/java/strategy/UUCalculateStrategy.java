package strategy;

public class UUCalculateStrategy implements CalculateStrategy {
    private final int rowCount;

    public UUCalculateStrategy(int rowCount) {
        this.rowCount = rowCount;
    }

    @Override
    public boolean isCalculable(int mineNumber) {
        return mineNumber - rowCount >= 0;
    }

    @Override
    public int getCalculateNumber(int number) {
        return number - rowCount;
    }
}