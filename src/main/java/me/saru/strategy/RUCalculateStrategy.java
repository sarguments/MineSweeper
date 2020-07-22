package me.saru.strategy;

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
        // 오른쪽 이동 가능 && 위쪽 이동 가능
        return (mineNumber % rowCount < rowCount - 1) && (mineNumber - rowCount > MIN);
    }

    @Override
    public int getCalculateNumber(int mineNumber) {
        return mineNumber - (rowCount - 1);
    }
}
