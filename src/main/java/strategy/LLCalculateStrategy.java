package strategy;

/**
 * 좌측 지뢰 카운트 증가 가능 여부 판단
 */
public class LLCalculateStrategy implements CalculateStrategy {
    private final int rowCount;

    public LLCalculateStrategy(int rowCount) {
        this.rowCount = rowCount;
    }

    @Override
    public boolean isCalculable(int mineNumber) {
        return mineNumber % rowCount > 0;
    }

    @Override
    public int getCalculateNumber(int number) {
        return number - 1;
    }
}
