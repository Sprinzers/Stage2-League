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
            if (knight.getHP() + Constants.HP_MOD_100 > knight.calculateTheoreticalHP()) {
                knight.setHP(knight.calculateTheoreticalHP());
            } else {
                knight.addHP(Constants.HP_MOD_100);
            }
            notifyHelp(knight);
        }
    }

    /**
     *  Method describes the effects of the angel.
     * @param pyromancer champion that the effects will be applied on.
     */
    @Override
    public void applyEffect(final Pyromancer pyromancer) {
        if (pyromancer.isAlive()) {
            if (pyromancer.getHP() + Constants.HP_MOD_80 > pyromancer.calculateTheoreticalHP()) {
                pyromancer.setHP(pyromancer.calculateTheoreticalHP());
            } else {
                pyromancer.addHP(Constants.HP_MOD_80);
            }
            notifyHelp(pyromancer);
        }
    }

    /**
     *  Method describes the effects of the angel.
     * @param rogue champion that the effects will be applied on.
     */
    @Override
    public void applyEffect(final Rogue rogue) {
        if (rogue.isAlive()) {
            if (rogue.getHP() + Constants.HP_MOD_90 > rogue.calculateTheoreticalHP()) {
                rogue.setHP(rogue.calculateTheoreticalHP());
            } else {
                rogue.addHP(Constants.HP_MOD_90);
            }
            notifyHelp(rogue);
        }
    }

    /**
     *  Method describes the effects of the angel.
     * @param wizard champion that the effects will be applied on.
     */
    @Override
    public void applyEffect(final Wizard wizard) {
        if (wizard.isAlive()) {
            if (wizard.getHP() + Constants.HP_MOD_120 > wizard.calculateTheoreticalHP()) {
                wizard.setHP(wizard.calculateTheoreticalHP());
            } else {
                wizard.addHP(Constants.HP_MOD_120);
            }
            notifyHelp(wizard);
        }
    }
}
