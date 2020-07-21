import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BoxManager {
    private final ArrayList<Box> boxes;

    // rowCount : 한 행의 갯수
    public BoxManager(int rowCount) {
        this.boxes = new ArrayList<>();

        for (int i = 0; i < rowCount * rowCount; i++) {
            boxes.add(new Box());
        }
    }

    public List<Integer> spread(List<Integer> boxNumbers) {
        boxNumbers.forEach(number -> boxes.get(number).increaseMineCount());

        return boxes.stream().map(Box::getMineCount).collect(Collectors.toList());
    }
}
