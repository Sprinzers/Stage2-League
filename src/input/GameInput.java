package input;

import java.util.ArrayList;
import java.util.List;

public class GameInput {
    private final List<String> terrainDescription;
    private final ArrayList<ArrayList<String>> championsOrder;
    private final List<String> roundsOrder;
    private final ArrayList<ArrayList<String>> angelSpawn;

    public GameInput() {
        terrainDescription = null;
        championsOrder = null;
        roundsOrder = null;
        angelSpawn = null;
    }

    public GameInput(final List<String> terrainDescription,
                     final ArrayList<ArrayList<String>> championsOrder,
                     final List<String> roundsOrder,
                     final ArrayList<ArrayList<String>> angelSpawn) {
        this.terrainDescription = terrainDescription;
        this.championsOrder = championsOrder;
        this.roundsOrder = roundsOrder;
        this.angelSpawn = angelSpawn;
    }

    public final List<String> getTerrainDescription() {
        return terrainDescription;
    }

    public final ArrayList<ArrayList<String>> getChampionsOrder() {
        return championsOrder;
    }

    public final List<String> getRoundsOrder() {
        return roundsOrder;
    }

    public final ArrayList<ArrayList<String>> getAngelSpawn() {
        return angelSpawn;
    }

    public final boolean isValidInput() {
        boolean membersInstantiated = terrainDescription != null && championsOrder != null
                && roundsOrder != null && angelSpawn != null;
        boolean membersNotEmpty = terrainDescription.size() > 0 && championsOrder.size() > 0
                && roundsOrder.size() > 0 && angelSpawn.size() > 0;
        return membersInstantiated && membersNotEmpty;
    }
}
