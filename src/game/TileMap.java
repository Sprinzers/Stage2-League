package game;

import java.util.ArrayList;
import java.util.List;

public final class TileMap {
    private final ArrayList<ArrayList<Tile>> map;
    private static TileMap instance = null;

    private TileMap() {
        map = new ArrayList<ArrayList<Tile>>();
    }

    /**
     *  Method is used to generate the map based on the input.
     */
    public static void generateMap(final List<String> terrain) {
        instance = new TileMap();
        for (int i = 0; i < terrain.size(); ++i) {
            ArrayList<Tile> currLine = new ArrayList<Tile>();
            for (int j = 0; j < terrain.get(i).length(); ++j) {
                char c = terrain.get(i).charAt(j);
                Tile currTile = new Tile(c);
                currLine.add(currTile);
            }
            instance.addMapLine(currLine);
        }
    }

    /**
     *  Method is used to add one created line to the map.
     * @param mapLine newly created line that is added to the map
     */
    public void addMapLine(final ArrayList<Tile> mapLine) {
        map.add(mapLine);
    }

    public char getTileType(final int x, final int y) {
        return map.get(x).get(y).getType();
    }

    public ArrayList<ArrayList<Tile>> getMap() {
        return map;
    }

    public static TileMap getInstance() {
        return instance;
    }
}
