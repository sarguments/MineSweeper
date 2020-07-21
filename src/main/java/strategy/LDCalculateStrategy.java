package strategy;

/**
 * 좌하단 지뢰 카운트 증가 가능 여부 판단
 */
public class LDCalculateStrategy implements CalculateStrategy {
    private final int rowCount;

    public LDCalculateStrategy(int rowCount) {
        this.rowCount = rowCount;
    }

    @Override
    public boolean isPassable(int mineNumber) {
        return (mineNumber % rowCount > 0) && (mineNumber + rowCount < rowCount * rowCount);
    }

    @Override
    public int getCalculateNumber(int number) {
        return number + (rowCount - 1);
    }
}
