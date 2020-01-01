package angel;

import champion.Knight;
import champion.Pyromancer;
import champion.Rogue;
import champion.Wizard;
import util.Constants;

public class Spawner extends Angel {

    public Spawner(final int posX, final int posY) {
        setPosX(posX);
        setPosY(posY);
    }
    /**
     *  Method describes the effects of the angel.
     * @param knight champion that the effects will be applied on.
     */
    @Override
    public void applyEffect(final Knight knight) {
        if (!knight.isAlive()) {
            knight.setHP(Constants.HP_MOD_200);
        }
    }
    /**
     *  Method describes the effects of the angel.
     * @param pyromancer champion that the effects will be applied on.
     */
    @Override
    public void applyEffect(final Pyromancer pyromancer) {
        if (!pyromancer.isAlive()) {
            pyromancer.setHP(Constants.HP_MOD_150);
        }
    }
    /**
     *  Method describes the effects of the angel.
     * @param rogue champion that the effects will be applied on.
     */
    @Override
    public void applyEffect(final Rogue rogue) {
        if (!rogue.isAlive()) {
            rogue.setHP(Constants.HP_MOD_180);
        }
    }
    /**
     *  Method describes the effects of the angel.
     * @param wizard champion that the effects will be applied on.
     */
    @Override
    public void applyEffect(final Wizard wizard) {
        if (!wizard.isAlive()) {
            wizard.setHP(Constants.HP_MOD_120);
        }
    }
}
