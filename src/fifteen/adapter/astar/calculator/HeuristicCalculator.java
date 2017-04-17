package fifteen.adapter.astar.calculator;

import fifteen.adapter.astar.Field;

public interface HeuristicCalculator {
    int getHeuristicWeight(Field from, Field to);
}
