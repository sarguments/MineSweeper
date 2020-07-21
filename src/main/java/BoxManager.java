import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BoxManager {
    private final List<Box> boxes;
    private final int rowCount;

    // rowCount : 한 행의 갯수
    public BoxManager(int rowCount) {
        this.boxes = new ArrayList<>();
        this.rowCount = rowCount;
    }

    public List<Integer> spread(List<Integer> boxNumbers) {
        boxesInit();

        boxNumbers.forEach(number -> boxes.get(number).increaseMineCount());

        return boxes.stream().map(Box::getMineCount).collect(Collectors.toList());
    }

    /**
     * spread() 를 중복 호출 하는 경우를 위해 초기화
     */
    private void boxesInit() {
        boxes.clear();

        for (int i = 0; i < rowCount * rowCount; i++) {
            boxes.add(new Box());
        }
    }

    public void print() {
        for (int i = 0; i < boxes.size(); i++) {
            if (i % rowCount == 0) {
                System.out.println();
            }

            System.out.printf("%3s", boxes.get(i));
        }

        System.out.println();
        System.out.println();
    }

    public boolean isEmpty() {
        return boxes.isEmpty();
    }
}
