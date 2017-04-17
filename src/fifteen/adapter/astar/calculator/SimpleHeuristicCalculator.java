package fifteen.adapter.astar.calculator;

import fifteen.adapter.astar.Field;

public class SimpleHeuristicCalculator implements HeuristicCalculator{

    /*
     * Возвращает количество несовпадений плиток.
     * Рекомендуется использовать ExtendedHeuristicCalculator
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
