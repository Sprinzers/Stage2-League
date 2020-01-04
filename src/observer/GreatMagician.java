package observer;

import angel.Angel;
import champion.Champion;

public class GreatMagician extends Observer {
    private static GreatMagician instance = null;

    private GreatMagician() {

    }

    public static GreatMagician getInstance() {
        if (instance == null) {
            instance = new GreatMagician();
        }
        return instance;
    }

    @Override
    public String updateKill(final Champion victim, final Champion killer) {
        return "Player " + victim.getFullName() + " " + victim.getID() +  " was killed by "
                + killer.getFullName() + " " + killer.getID() + "\n";
    }

    @Override
    public String updateSpawn(final Angel angel) {
        return "Angel " + angel.getName() + " was spawned at " + angel.getPosX() + " "
                + angel.getPosY() + "\n";
    }
}
