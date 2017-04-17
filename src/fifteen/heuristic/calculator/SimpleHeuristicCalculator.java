package fifteen.heuristic.calculator;

import fifteen.Field;

/**
 * Created by eldar on 16.04.17.
 */
public class SimpleHeuristicCalculator implements HeuristicCalculator{

    /*
     * Возвращает количество несовпадений плиток.
     */
    @Override
    public int getHeuristicWeight(Field from, Field to) {
        if (from.getSize() == to.getSize()) {
            int size = from.getSize();
            int mismatchesCount = 0;
            for (int idx = 0; idx < size * size; ++idx) {
                if (from.getAt(idx) != to.getAt(idx)) {
                    ++mismatchesCount;
                }
            }
            return mismatchesCount;
        } else {
            return Integer.MIN_VALUE;
        }
    }
}
