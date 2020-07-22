package me.saru.strategy;

/**
 * 우측 지뢰 카운트 증가 가능 여부 판단
 */
public class RRCalculateStrategy implements CalculateStrategy {
    private final int rowCount;

    public RRCalculateStrategy(int rowCount) {
        this.rowCount = rowCount;
    }

    @Override
    public boolean isPassable(int mineNumber) {
        return mineNumber % rowCount < rowCount - 1;
    }

    @Override
    public int getCalculateNumber(int mineNumber) {
        return mineNumber + 1;
    }
}