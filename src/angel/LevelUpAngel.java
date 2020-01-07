package angel;

import champion.Knight;
import champion.Pyromancer;
import champion.Rogue;
import champion.Wizard;
import util.Constants;


public class LevelUpAngel extends Angel {

    public LevelUpAngel(final int posX, final int posY) {
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
            int levelUpLimit = knight.calculateLevelUpLimit();
            knight.addXP(levelUpLimit - knight.getXP());
            knight.increaseLevel();
            knight.increaseRaceMod(Constants.DAMAGE_MOD_10);
            notifyHelp(knight);
            notifyLevelUp(knight);
            knight.setHP(knight.calculateTheoreticalHP());
        }
    }

    /**
     *  Method describes the effects of the angel.
     * @param pyromancer champion that the effects will be applied on.
     */
    @Override
    public void applyEffect(final Pyromancer pyromancer) {
        if (pyromancer.isAlive()) {
            int levelUpLimit = pyromancer.calculateLevelUpLimit();
            pyromancer.addXP(levelUpLimit - pyromancer.getXP());
            pyromancer.increaseLevel();
            pyromancer.increaseRaceMod(Constants.DAMAGE_MOD_20);
            notifyHelp(pyromancer);
            notifyLevelUp(pyromancer);
            pyromancer.setHP(pyromancer.calculateTheoreticalHP());
        }
    }

    /**
     *  Method describes the effects of the angel.
     * @param rogue champion that the effects will be applied on.
     */
    @Override
    public void applyEffect(final Rogue rogue) {
        if (rogue.isAlive()) {
            int levelUpLimit = rogue.calculateLevelUpLimit();
            rogue.addXP(levelUpLimit - rogue.getXP());
            rogue.increaseLevel();
            rogue.increaseRaceMod(Constants.DAMAGE_MOD_15);
            notifyHelp(rogue);
            notifyLevelUp(rogue);
            rogue.setHP(rogue.calculateTheoreticalHP());
        }
    }

    /**
     *  Method describes the effects of the angel.
     * @param wizard champion that the effects will be applied on.
     */
    @Override
    public void applyEffect(final Wizard wizard) {
        if (wizard.isAlive()) {
            int levelUpLimit = wizard.calculateLevelUpLimit();
            wizard.addXP(levelUpLimit - wizard.getXP());
            wizard.increaseLevel();
            wizard.increaseRaceMod(Constants.DAMAGE_MOD_25);
            notifyHelp(wizard);
            notifyLevelUp(wizard);
            wizard.setHP(wizard.calculateTheoreticalHP());
        }
    }
}
