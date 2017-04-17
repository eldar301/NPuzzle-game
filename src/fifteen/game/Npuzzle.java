package fifteen.game;

import astar.Astar;
import fifteen.adapter.astar.Field;
import fifteen.adapter.astar.FieldHandler;

import java.util.List;

/**
 * Created by Eldar on 17.04.2017.
 */
public class Npuzzle {

    private final int fieldSize;
    private final int shuffleCount = 50;
    private Field currentField;
    private Field finiteField;

    private Astar<Field, FieldHandler> solver;

    public Npuzzle(int fieldSize) {
        this.fieldSize = fieldSize;
        int[] fieldRow = new int[fieldSize * fieldSize];
        for (int idx = 0; idx < fieldRow.length; ++idx) {
            fieldRow[idx] = (idx + 1) % fieldRow.length;
        }
        try {
            finiteField = new Field(fieldSize, fieldRow);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        solver = new Astar<>(new FieldHandler());
    }

    public Field generateInitialField() {
        currentField = new Field(finiteField);
        currentField.shuffle(shuffleCount);
        return currentField;
    }

    public Field getCurrentField() {
        return currentField;
    }

    public List<Field> getSolution() {
        return solver.doSearch(currentField, finiteField).getStack();
    }
}
