package me.saru.strategy;

/**
 * 좌측 지뢰 카운트 증가 가능 여부 판단
 */
public class LLCalculateStrategy implements CalculateStrategy {
    private final int rowCount;

    public LLCalculateStrategy(int rowCount) {
        this.rowCount = rowCount;
    }

    @Override
    public boolean isPassable(int mineNumber) {
        return mineNumber % rowCount > MIN;
    }

    @Override
    public int getCalculateNumber(int mineNumber) {
        return mineNumber - 1;
    }
}
