package fifteen.adapter.astar;

import astar.StateHandler;
import fifteen.adapter.astar.calculator.ExtendedHeuristicCalculator;
import fifteen.adapter.astar.calculator.HeuristicCalculator;

import java.util.LinkedList;
import java.util.List;

public class FieldHandler implements StateHandler<Field> {

    private HeuristicCalculator calculator;

    public FieldHandler() {
        calculator = new ExtendedHeuristicCalculator();
    }

    public void setHeuristicCalculator(HeuristicCalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public List<Field> getNeighbours(Field parent) {
        List<Field> neighbours = new LinkedList<>();

        Field neighbour;

        neighbour = new Field(parent);
        if (neighbour.turnUp()) {
            neighbours.add(neighbour);
        }
        neighbour = new Field(parent);
        if (neighbour.turnRight()) {
            neighbours.add(neighbour);
        }
        neighbour = new Field(parent);
        if (neighbour.turnDown()) {
            neighbours.add(neighbour);
        }
        neighbour = new Field(parent);
        if (neighbour.turnLeft()) {
            neighbours.add(neighbour);
        }

        return neighbours;
    }

    @Override
    public int getHeuristicWeight(Field from, Field to) {
        return calculator.getHeuristicWeight(from, to);
    }
}