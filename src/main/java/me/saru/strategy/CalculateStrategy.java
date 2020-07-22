package me.saru.strategy;

/**
 * 지뢰 카운트 증가 가능 여부 판단
 */
public interface CalculateStrategy {
    int MIN = 0;

    // 주어진 지뢰 위치에 대해서 현재 전략이 적용 가능한지 판단
    boolean isPassable(int mineNumber);

    // 주어진 지뢰 위치로 부터 현재 전략을 적용 해서 카운트를 증가시킬 박스 넘버를 얻는다
    int getCalculateNumber(int mineNumber);
}
