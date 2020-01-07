package observer;

import angel.Angel;
import champion.Champion;

public abstract class Observer {

    public abstract void updateKill(Champion victim, Champion killer);

    public abstract void updateSpawn(Angel angel);

    public abstract void updateHit(Angel angel, Champion champion);

    public abstract void updateHelp(Angel angel, Champion champion);

    public abstract void updateRevive(Champion champion);

    public abstract void updateLevelUp(Champion champion);

    public abstract void updateKillByAgel(Champion champion);

}
