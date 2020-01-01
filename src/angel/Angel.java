package angel;

import champion.Knight;
import champion.Pyromancer;
import champion.Rogue;
import champion.Wizard;

public abstract class Angel {
    private int posX;
    private int posY;

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
