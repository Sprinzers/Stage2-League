package angel;

import champion.Knight;
import champion.Pyromancer;
import champion.Rogue;
import champion.Wizard;
import util.Constants;

public class XPAngel extends Angel {

    public XPAngel(final int posX, final int posY) {
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
            knight.addXP(Constants.XP_45);
            if (knight.getXP() >= knight.calculateLevelUpLimit()) {
                knight.increaseLevel();
            }
        }
    }
    /**
     *  Method describes the effects of the angel.
     * @param pyromancer champion that the effects will be applied on.
     */
    @Override
    public void applyEffect(final Pyromancer pyromancer) {
        if (pyromancer.isAlive()) {
            pyromancer.addXP(Constants.XP_50);
            if (pyromancer.getXP() >= pyromancer.calculateLevelUpLimit()) {
                pyromancer.increaseLevel();
            }
        }
    }
    /**
     *  Method describes the effects of the angel.
     * @param rogue champion that the effects will be applied on.
     */
    @Override
    public void applyEffect(final Rogue rogue) {
        if (rogue.isAlive()) {
            rogue.addXP(Constants.XP_40);
            if (rogue.getXP() >= rogue.calculateLevelUpLimit()) {
                rogue.increaseLevel();
            }
        }
    }
    /**
     *  Method describes the effects of the angel.
     * @param wizard champion that the effects will be applied on.
     */
    @Override
    public void applyEffect(final Wizard wizard) {
        if (wizard.isAlive()) {
            wizard.addXP(Constants.XP_60);
            if (wizard.getXP() >= wizard.calculateLevelUpLimit()) {
                wizard.increaseLevel();
            }
        }
    }
}
