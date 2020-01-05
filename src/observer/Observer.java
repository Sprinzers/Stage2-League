package observer;

import angel.Angel;
import champion.Champion;

import java.io.IOException;

public abstract class Observer {
    protected Angel subject;

    public abstract void updateKill(final Champion victim, final Champion killer) throws IOException;

    public abstract void updateSpawn(final Angel angel) throws IOException;

    public abstract void updateHit(final Angel angel, final Champion champion) throws IOException;

    public abstract void updateHelp(final Angel angel, final Champion champion) throws IOException;

    public abstract void updateRevive(final Champion champion) throws IOException;

    public abstract void updateLevelUp(final Champion champion) throws IOException;

    public abstract void updateKillByAgel(final Champion champion) throws IOException;
}
