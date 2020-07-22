package me.saru.strategy;

/**
 * 하단 지뢰 카운트 증가 가능 여부 판단
 */
public class DDCalculateStrategy implements CalculateStrategy {
    private final int rowCount;

    public DDCalculateStrategy(int rowCount) {
        this.rowCount = rowCount;
    }

    @Override
    public boolean isPassable(int mineNumber) {
        return mineNumber + rowCount < rowCount * rowCount;
    }

    @Override
    public int getCalculateNumber(int mineNumber) {
        return mineNumber + rowCount;
    }
}
