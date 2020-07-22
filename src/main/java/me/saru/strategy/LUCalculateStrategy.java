package me.saru.strategy;

/**
 * 좌상단 지뢰 카운트 증가 가능 여부 판단
 */
public class LUCalculateStrategy implements CalculateStrategy {
    private final int rowCount;

    public LUCalculateStrategy(int rowCount) {
        this.rowCount = rowCount;
    }

    @Override
    public boolean isPassable(int mineNumber) {
        // 왼쪽 이동 가능 && 위쪽 이동 가능
        return (mineNumber % rowCount > 0) && (mineNumber - rowCount >= MIN);
    }

    @Override
    public int getCalculateNumber(int mineNumber) {
        return mineNumber - (rowCount + 1);
    }
}
