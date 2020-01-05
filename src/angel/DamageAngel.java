package angel;

import champion.*;
import util.Constants;

import java.io.IOException;

public class DamageAngel extends Angel {

    public DamageAngel(final int posX, final int posY) {
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
            knight.increaseRaceMod(Constants.DAMAGE_MOD_15);
            notifyHelp(knight);
        }
    }
    /**
     *  Method describes the effects of the angel.
     * @param pyromancer champion that the effects will be applied on.
     */
    @Override
    public void applyEffect(final Pyromancer pyromancer) throws IOException {
        if (pyromancer.isAlive()) {
            pyromancer.increaseRaceMod(Constants.DAMAGE_MOD_20);
            notifyHelp(pyromancer);
        }
    }
    /**
     *  Method describes the effects of the angel.
     * @param rogue champion that the effects will be applied on.
     */
    @Override
    public void applyEffect(final Rogue rogue) throws IOException {
        if (rogue.isAlive()) {
            rogue.increaseRaceMod(Constants.DAMAGE_MOD_30);
            notifyHelp(rogue);
        }
    }
    /**
     *  Method describes the effects of the angel.
     * @param wizard champion that the effects will be applied on.
     */
    @Override
    public void applyEffect(final Wizard wizard) throws IOException {
        if (wizard.isAlive()) {
            wizard.increaseRaceMod(Constants.DAMAGE_MOD_40);
            notifyHelp(wizard);
        }
    }
}
