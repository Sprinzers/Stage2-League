package game;

public class Tile {
    private final char type;

    Tile(final char newType) {
        type = newType;
    }

    /**
     *  Method is used to get the type of the location.
     * @return character representing the terrain type
     */
    public char getType() {
        return type;
    }
}
