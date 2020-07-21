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
