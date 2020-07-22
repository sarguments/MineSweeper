package me.saru.strategy;

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
        // 왼쪽 이동 가능 && 아래쪽 이동 가능
        return (mineNumber % rowCount > MIN) && (mineNumber + rowCount < rowCount * rowCount);
    }

    @Override
    public int getCalculateNumber(int mineNumber) {
        return mineNumber + (rowCount - 1);
    }
}
