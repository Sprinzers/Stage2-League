package angel;

import champion.Knight;
import champion.Pyromancer;
import champion.Rogue;
import champion.Wizard;

import java.io.IOException;

public class TheDoomer extends Angel {

    public TheDoomer(final int posX, final int posY) {
        setPosX(posX);
        setPosY(posY);
    }
    /**
     *  Method describes the effects of the angel.
     * @param knight champion that the effects will be applied on.
     */
    @Override
    public void applyEffect(final Knight knight) throws IOException {
        if (knight.isAlive()) {
            knight.setHP(0);
            notifyHit(knight);
            notifyKill(knight);
        }
    }
    /**
     *  Method describes the effects of the angel.
     * @param pyromancer champion that the effects will be applied on.
     */
    @Override
    public void applyEffect(final Pyromancer pyromancer) throws IOException {
        if (pyromancer.isAlive()) {
            pyromancer.setHP(0);
            notifyHit(pyromancer);
            notifyKill(pyromancer);
        }
    }
    /**
     *  Method describes the effects of the angel.
     * @param rogue champion that the effects will be applied on.
     */
    @Override
    public void applyEffect(final Rogue rogue) throws IOException {
        if (rogue.isAlive()) {
            rogue.setHP(0);
            notifyHit(rogue);
            notifyKill(rogue);
        }
    }
    /**
     *  Method describes the effects of the angel.
     * @param wizard champion that the effects will be applied on.
     */
    @Override
    public void applyEffect(final Wizard wizard) throws IOException {
        if (wizard.isAlive()) {
            wizard.setHP(0);
            notifyHit(wizard);
            notifyKill(wizard);
        }
    }
}
