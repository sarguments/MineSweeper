import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 지뢰찾기 빈칸(박스)를 초기화 시키고, 주어지는 번호에 해당하는 박스들의 지뢰 카운트를 증가시킨다.
 * 박스 리스트는 2차원 지뢰찾기 테이블을 1차원으로 펼친 것으로 가정한다.
 */
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
