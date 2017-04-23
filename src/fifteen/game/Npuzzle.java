package fifteen.game;

import astar.Astar;
import astar.SearchResult;

import java.util.List;

/**
 * Created by Eldar on 17.04.2017.
 */
public class Npuzzle {

    private final int fieldSize;
    private Field currentField;
    private Field finiteField;

    private Npuzzle(int fieldSize, int[] finiteArrangement) {
        this.fieldSize = fieldSize;
        try {
            finiteField = new Field(fieldSize, finiteArrangement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Npuzzle createConventional(int size) {
        int[] finiteArray = new int[size * size];
        for (int idx = 0; idx < finiteArray.length; ++idx) {
            finiteArray[idx] = (idx + 1) % finiteArray.length;
        }
        return new Npuzzle(size, finiteArray);
    }

    public static Npuzzle createSpiral(int size) {
        int[] finiteArray = new int[size * size];
        final int RIGHT = 1;
        final int LEFT = -1;
        final int UP = -size;
        final int DOWN = size;
        int dir = RIGHT;
        int pos = 0;
        for (int idx = 0; idx < finiteArray.length; ++idx) {
            finiteArray[pos] = (idx + 1) % finiteArray.length;
            int nextPos = pos + dir;
            if (pos == size - 1 || pos == size * size - 1 || pos == size * (size - 1) || finiteArray[nextPos] != 0) {
                if (dir == RIGHT) {
                    dir = DOWN;
                } else if (dir == LEFT) {
                    dir = UP;
                } else if (dir == UP) {
                    dir = RIGHT;
                } else {
                    dir = LEFT;
                }
            }
            pos += dir;
        }
        return new Npuzzle(size, finiteArray);
    }

    public void generateInitialField(int shuffleCount) {
        currentField = new Field(finiteField);
        currentField.shuffle(shuffleCount);
    }

    public Field getCurrentField() {
        return currentField;
    }

    public boolean turnRight() {
        return currentField.turnRight();
    }

    public boolean turnDown() {
        return currentField.turnDown();
    }

    public boolean turnLeft() {
        return currentField.turnLeft();
    }

    public boolean turnUp() {
        return currentField.turnUp();
    }

    public boolean turnTo(int num) {
        return currentField.turnTo(num);
    }

    public boolean isSolved() {
        return finiteField.equals(currentField);
    }

    public List<Field> solve() {
        Astar<Field, FieldHandler> solver = new Astar<>(new FieldHandler());
        SearchResult<Field> solution =  solver.doSearch(currentField, finiteField);
        currentField = new Field(finiteField);
        return solution.getStack();
    }
}
