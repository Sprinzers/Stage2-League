package angel;

import champion.Knight;
import champion.Pyromancer;
import champion.Rogue;
import champion.Wizard;
import util.Constants;

public class Dracula extends Angel {

    public Dracula(final int posX, final int posY) {
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
            knight.reduceRaceMod(Constants.DAMAGE_MOD_20);
            knight.reduceHP(Constants.HP_MOD_60);
        }
    }
    /**
     *  Method describes the effects of the angel.
     * @param pyromancer champion that the effects will be applied on.
     */
    @Override
    public void applyEffect(final Pyromancer pyromancer) {
        if (pyromancer.isAlive()) {
            pyromancer.reduceRaceMod(Constants.DAMAGE_MOD_30);
            pyromancer.reduceHP(Constants.HP_MOD_40);
        }
    }
    /**
     *  Method describes the effects of the angel.
     * @param rogue champion that the effects will be applied on.
     */
    @Override
    public void applyEffect(final Rogue rogue) {
        if (rogue.isAlive()) {
            rogue.reduceRaceMod(Constants.DAMAGE_MOD_10);
            rogue.reduceHP(Constants.HP_MOD_35);
        }
    }
    /**
     *  Method describes the effects of the angel.
     * @param wizard champion that the effects will be applied on.
     */
    @Override
    public void applyEffect(final Wizard wizard) {
        if (wizard.isAlive()) {
            wizard.reduceRaceMod(Constants.DAMAGE_MOD_40);
            wizard.reduceHP(Constants.HP_MOD_20);
        }
    }
}
