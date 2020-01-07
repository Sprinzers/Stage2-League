package angel;

import champion.Champion;
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

    public final boolean verifyChampionPosition(final Champion champion) {
        return champion.getPosX() == getPosX() && champion.getPosY() == getPosY();
    }

    final Observer getObserver() {
        return observer;
    }

    /**
     *  Method is used to notify the observer when an angel spawns.
     */
    private void notifySpawn() {
        observer.updateSpawn(this);
    }

    /**
     *  Method is used to notify the observer when a bad angel interacts with a champion.
     * @param champion champion hit
     */
    final void notifyHit(final Champion champion) {
        observer.updateHit(this, champion);
    }

    /**
     *  Method is used to notify the observer when a good angel interacts with a champion.
     * @param champion champion helped
     */
    final void notifyHelp(final Champion champion) {
        observer.updateHelp(this, champion);
    }

    /**
     *  Method is used to notify the observer when an angel levels a champion up.
     * @param champion champion leveled up
     */
    final void notifyLevelUp(final Champion champion) {
        observer.updateLevelUp(champion);
    }

    /**
     *  Method is used to notify the observer when an angels kills a champion.
     * @param champion champion killed
     */
    final void notifyKill(final Champion champion) {
        observer.updateKillByAgel(champion);
    }

    public final void addObserver(final Observer newObserver) {
        observer = newObserver;
    }

    public final boolean isSpawned() {
        return spawned;
    }

    public final void spawnAngel() {
        spawned = true;
        notifySpawn();
    }

    public final String getName() {
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
