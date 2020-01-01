package angel;

import champion.Knight;
import champion.Pyromancer;
import champion.Rogue;
import champion.Wizard;
import util.Constants;

public class LifeGiver extends Angel {

    public LifeGiver(final int posX, final int posY) {
        setPosX(posX);
        setPosY(posY);
    }
    /**
     *  Method describes the effects of the angel.
     * @param knight champion that the effects will be applied on.
     */
    @Override
    public void applyEffect(final Knight knight) {
        if (knight.isAlive()) {
            knight.addHP(Constants.HP_MOD_100);
        }
    }
    /**
     *  Method describes the effects of the angel.
     * @param pyromancer champion that the effects will be applied on.
     */
    @Override
    public void applyEffect(final Pyromancer pyromancer) {
        if (pyromancer.isAlive()) {
            pyromancer.addHP(Constants.HP_MOD_80);
        }
    }
    /**
     *  Method describes the effects of the angel.
     * @param rogue champion that the effects will be applied on.
     */
    @Override
    public void applyEffect(final Rogue rogue) {
        if (rogue.isAlive()) {
            rogue.addHP(Constants.HP_MOD_90);
        }
    }
    /**
     *  Method describes the effects of the angel.
     * @param wizard champion that the effects will be applied on.
     */
    @Override
    public void applyEffect(final Wizard wizard) {
        if (wizard.isAlive()) {
            wizard.addHP(Constants.HP_MOD_120);
        }
    }
}
