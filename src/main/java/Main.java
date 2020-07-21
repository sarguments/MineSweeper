import util.RandomNumbers;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(10, RandomNumbers.generate(0, 100, 10));
        game.spread();
        game.print();
    }
}
