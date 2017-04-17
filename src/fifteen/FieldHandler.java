package fifteen;

import astar.StateHandler;
import fifteen.heuristic.calculator.HeuristicCalculator;
import fifteen.heuristic.calculator.SimpleHeuristicCalculator;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by eldar on 16.04.17.
 */
public class FieldHandler implements StateHandler<Field> {

    private HeuristicCalculator calculator;

    public FieldHandler() {
        calculator = new SimpleHeuristicCalculator();
    }

    public void setHeuristicCalculator(HeuristicCalculator calculator) {
        this.calculator = calculator;
    }

    public boolean isSolvable(Field initial, Field solution) {
        return false;
    }

    @Override
    public List<Field> getNeighbours(Field parent) {
        List<Field> neighbours = new LinkedList<>();

        Field neighbour;
        neighbour = Field.turnDown(parent);
        if (neighbour != null) {
            neighbours.add(neighbour);
        }
        neighbour = Field.turnLeft(parent);
        if (neighbour != null) {
            neighbours.add(neighbour);
        }
        neighbour = Field.turnRight(parent);
        if (neighbour != null) {
            neighbours.add(neighbour);
        }
        neighbour = Field.turnUp(parent);
        if (neighbour != null) {
            neighbours.add(neighbour);
        }

        return neighbours;
    }

    @Override
    public int getHeuristicWeight(Field from, Field to) {
        return calculator.getHeuristicWeight(from, to);
    }
}