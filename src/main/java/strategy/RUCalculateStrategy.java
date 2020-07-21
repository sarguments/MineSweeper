package strategy;

/**
 * 우상단 지뢰 카운트 증가 가능 여부 판단
 */
public class RUCalculateStrategy implements CalculateStrategy {
    private final int rowCount;

    public RUCalculateStrategy(int rowCount) {
        this.rowCount = rowCount;
    }

    @Override
    public boolean isPassable(int mineNumber) {
        return (mineNumber % rowCount < rowCount - 1) && (mineNumber - rowCount > 0);
    }

    @Override
    public int getCalculateNumber(int number) {
        return number - (rowCount - 1);
    }
}
