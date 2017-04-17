package astar;

import java.util.List;

/**
 * Created by eldar on 16.04.17.
 */
public interface StateHandler<S extends State> {
    List<S> getNeighbours(S parent);
    int getHeuristicWeight(S from, S to);
}
