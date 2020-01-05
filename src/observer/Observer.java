package observer;

import angel.Angel;
import champion.Champion;

import java.io.IOException;

public abstract class Observer {
    protected Angel subject;

    public abstract void updateKill(Champion victim, Champion killer) throws IOException;

    public abstract void updateSpawn(Angel angel) throws IOException;

    public abstract void updateHit(Angel angel, Champion champion) throws IOException;

    public abstract void updateHelp(Angel angel, Champion champion) throws IOException;

    public abstract void updateRevive(Champion champion) throws IOException;

    public abstract void updateLevelUp(Champion champion) throws IOException;

    public abstract void updateKillByAgel(Champion champion) throws IOException;
}
