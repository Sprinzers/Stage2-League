package observer;

import angel.Angel;
import champion.Champion;

public abstract class Observer {
    protected Angel subject;

    public abstract String updateKill(final Champion victim, final Champion killer);

    public abstract String updateSpawn(final Angel angel);
}
