package fifteen.heuristic.calculator;

import fifteen.Field;

/**
 * Created by eldar on 16.04.17.
 */
public class ExtendedHeuristicCalculator implements HeuristicCalculator {

   /*
    * Возвращает сумму, в которой содержится общий суммарный путь,
    * который необходимо пройти плитке от ее текущего до конечного положения.
    */
    @Override
    public int getHeuristicWeight(Field from, Field to) {
        //TODO
        return 0;
    }

    private int getRoughDistance(int xFrom, int yFrom, int xTo, int yTo) {
        return Math.abs(xFrom - xTo) + Math.abs(yFrom - yTo);
    }
}
