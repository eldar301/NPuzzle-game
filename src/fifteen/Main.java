package fifteen;

import astar.Astar;
import astar.SearchResult;

/**
 * Created by Eldar on 17.04.2017.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Field result = new Field(4, new int[]{1, 2, 3, 4,
                                              5, 6, 7, 8,
                                              9, 10, 11, 12,
                                              13, 14, 15, 0});
        for (int idx = 0; idx < 10; ++idx) {
            Field initial = new Field(result);
            initial.shuffle(50);
            Astar<Field, FieldHandler> astar = new Astar<>(new FieldHandler());
            SearchResult<Field> searchResult = astar.doSearch(initial, result);
            System.out.println(searchResult);
        }
    }
}