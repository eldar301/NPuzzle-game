package astar;

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
        //TODO
    }

    private List<S> buildPath(S solution) {
        return null;
    }

}
