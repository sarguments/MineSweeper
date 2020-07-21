import java.util.List;

public class Game {
    private final MineManager mineManager;
    private final BoxManager boxManager;

    public Game(int rowCount, List<Integer> mineNumbers) {
        this.mineManager = new MineManager(mineNumbers, rowCount);
        this.boxManager = new BoxManager(rowCount);
    }

    public List<Integer> spread() {
        return boxManager.spread(mineManager.calcMineNumbers());
    }

    public void print() {
        boxManager.print();
    }
}
