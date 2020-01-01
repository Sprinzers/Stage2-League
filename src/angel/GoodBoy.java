package angel;

import champion.Knight;
import champion.Pyromancer;
import champion.Rogue;
import champion.Wizard;
import util.Constants;

public class GoodBoy extends Angel {

    public GoodBoy(final int posX, final int posY) {
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
            knight.increaseRaceMod(Constants.DAMAGE_MOD_40);
            knight.addHP(Constants.HP_MOD_20);
        }
    }
    /**
     *  Method describes the effects of the angel.
     * @param pyromancer champion that the effects will be applied on.
     */
    @Override
    public void applyEffect(final Pyromancer pyromancer) {
        if (pyromancer.isAlive()) {
            pyromancer.increaseRaceMod(Constants.DAMAGE_MOD_50);
            pyromancer.addHP(Constants.HP_MOD_30);
        }
    }
    /**
     *  Method describes the effects of the angel.
     * @param rogue champion that the effects will be applied on.
     */
    @Override
    public void applyEffect(final Rogue rogue) {
        if (rogue.isAlive()) {
            rogue.increaseRaceMod(Constants.DAMAGE_MOD_40);
            rogue.addHP(Constants.HP_MOD_40);
        }
    }
    /**
     *  Method describes the effects of the angel.
     * @param wizard champion that the effects will be applied on.
     */
    @Override
    public void applyEffect(final Wizard wizard) {
        if (wizard.isAlive()) {
            wizard.increaseRaceMod(Constants.DAMAGE_MOD_30);
            wizard.addHP(Constants.HP_MOD_50);
        }
    }
}
