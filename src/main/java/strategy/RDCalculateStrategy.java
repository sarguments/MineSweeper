package strategy;

/**
 * 우하단 지뢰 카운트 증가 가능 여부 판단
 */
public class RDCalculateStrategy implements CalculateStrategy {
    private final int rowCount;

    public RDCalculateStrategy(int rowCount) {
        this.rowCount = rowCount;
    }

    @Override
    public boolean isPassable(int mineNumber) {
        return (mineNumber % rowCount < rowCount - 1) && (mineNumber + rowCount < rowCount * rowCount);
    }

    @Override
    public int getCalculateNumber(int number) {
        return number + (rowCount + 1);
    }
}
