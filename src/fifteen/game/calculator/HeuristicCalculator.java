package fifteen.game.calculator;

import fifteen.game.Field;

public interface HeuristicCalculator {
    int getHeuristicWeight(Field from, Field to);
}
