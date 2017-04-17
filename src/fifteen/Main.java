package fifteen;

import astar.Astar;
import astar.SearchResult;
import fifteen.adapter.astar.Field;
import fifteen.adapter.astar.FieldHandler;
import fifteen.game.Npuzzle;

public class Main {
    public static void main(String[] args) throws Exception {
        Npuzzle threeByThree = new Npuzzle(3);
        threeByThree.generateInitialField();
        for (Field step : threeByThree.getSolution()) {
            System.out.println(step);
        }
    }
}