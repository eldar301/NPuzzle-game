package astar;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by eldar on 16.04.17.
 */
public class Astar<S extends State, SH extends StateHandler<S>> {

    private SH stateHandler;

    public Astar(SH stateHandler) {
        this.stateHandler = stateHandler;
    }

    public List<S> doSearch(S from, S to) {
        List<S> openedList = new LinkedList<>();
        List<S> closedList = new LinkedList<>();
        from.clear();
        to.clear();
        openedList.add(from);
        while (!openedList.isEmpty()) {
            S current = null;
            int minF = Integer.MAX_VALUE;
            for (S state : openedList) {
                if (state.getF() < minF) {
                    minF = state.getF();
                    current = state;
                }
            }
            if (current.equals(to)) {
                return buildPath(current);
            }
            openedList.remove(current);
            closedList.add(current);

            List<S> neighbours = stateHandler.getNeighbours(current);
            for (S neighbour : neighbours) {
                if (closedList.contains(neighbour)) {
                    continue;
                }
                int estimatedG = current.getG() + 1;
                if (neighbour.getParent() != null) {
                    if (neighbour.getG() > estimatedG) {
                        neighbour.setParent(current);
                        neighbour.setG(estimatedG);
                        neighbour.setH(stateHandler.getHeuristicWeight(neighbour, to));
                    }
                } else {
                    neighbour.setParent(current);
                    neighbour.setG(estimatedG);
                    neighbour.setH(stateHandler.getHeuristicWeight(neighbour, to));
                }
            }
        }
    }

    private List<S> buildPath(S solution) {
        LinkedList<S> result = new LinkedList<>();
        S stacked = solution;
        while (stacked != null) {
            result.addFirst(stacked);
            stacked = stacked.getParent();
        }
        return result;
    }

}
