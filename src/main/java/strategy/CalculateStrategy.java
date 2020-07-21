package strategy;

/**
 * 지뢰 카운트 증가 가능 여부 판단
 */
public interface CalculateStrategy {
    boolean isCalculable(int mineNumber);

    int getCalculateNumber(int number);
}
