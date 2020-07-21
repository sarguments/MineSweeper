/**
 * 지뢰 카운트를 가지는 빈칸(박스)
 */
public class Box {
    private int mineCount;

    public void increaseMineCount() {
        mineCount++;
    }

    public int getMineCount() {
        return mineCount;
    }

    @Override
    public String toString() {
        return String.valueOf(mineCount);
    }
}
