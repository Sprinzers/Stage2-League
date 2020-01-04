package angel;

import champion.Knight;
import champion.Pyromancer;
import champion.Rogue;
import champion.Wizard;
import observer.Observer;

public abstract class Angel {
    private boolean spawned;
    private int posX;
    private int posY;
    private Observer observer;


    public Observer getObserver() {
        return observer;
    }

    public String notifySpawn() {
        return observer.updateSpawn(this);
    }

    public void addObserver(Observer newObserver) {
        observer = newObserver;
    }

    public boolean isSpawned() {
        return spawned;
    }

    public String spawnAngel() {
        spawned = true;
        return notifySpawn();
    }

    public String getName() {
        return getClass().getName().substring(getClass().getName().lastIndexOf(".") + 1);
    }

    public final int getPosX() {
        return posX;
    }

    public final void setPosX(final int posX) {
        this.posX = posX;
    }

    public final int getPosY() {
        return posY;
    }

    public final void setPosY(final int posY) {
        this.posY = posY;
    }

    public abstract void applyEffect(Knight knight);

    public abstract void applyEffect(Pyromancer pyromancer);

    public abstract void applyEffect(Rogue rogue);

    public abstract void applyEffect(Wizard wizard);
}
