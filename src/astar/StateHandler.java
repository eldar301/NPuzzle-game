package astar;

import java.util.List;

public interface StateHandler<S extends State> {
    List<S> getNeighbours(S parent);
    int getHeuristicWeight(S from, S to);
}
