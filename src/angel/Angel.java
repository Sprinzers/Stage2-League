package angel;

import champion.*;
import observer.Observer;

import java.io.IOException;

public abstract class Angel {
    private boolean spawned;
    private int posX;
    private int posY;
    private Observer observer;

    public boolean verifyChampionPosition(final Champion champion) {
        if (champion.getPosX() == getPosX() && champion.getPosY() == getPosY()) {
            return true;
        } else {
            return false;
        }
    }

    public Observer getObserver() {
        return observer;
    }

    public void notifySpawn() throws IOException {
        observer.updateSpawn(this);
    }

    public void notifyHit(final Champion champion) throws IOException {
        observer.updateHit(this, champion);
    }

    public void notifyHelp(final Champion champion) throws IOException {
        observer.updateHelp(this, champion);
    }

    public void notifyLevelUp(final Champion champion) throws IOException {
        observer.updateLevelUp(champion);
    }

    public void notifyKill(final Champion champion) throws IOException {
        observer.updateKillByAgel(champion);
    }

    public void addObserver(Observer newObserver) {
        observer = newObserver;
    }

    public boolean isSpawned() {
        return spawned;
    }

    public void spawnAngel() throws IOException {
        spawned = true;
        notifySpawn();
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

    public abstract void applyEffect(Knight knight) throws IOException;

    public abstract void applyEffect(Pyromancer pyromancer) throws IOException;

    public abstract void applyEffect(Rogue rogue) throws IOException;

    public abstract void applyEffect(Wizard wizard) throws IOException;
}
