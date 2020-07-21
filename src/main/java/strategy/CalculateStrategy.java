package strategy;

public interface CalculateStrategy {
    boolean isCalculable(int mineNumber);

    int getCalculateNumber(int number);
}
