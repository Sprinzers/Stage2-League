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
            if (knight.getHP() + Constants.HP_MOD_20 > knight.calculateTheoreticalHP()) {
                knight.setHP(knight.calculateTheoreticalHP());
            } else {
                knight.addHP(Constants.HP_MOD_20);
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
            pyromancer.increaseRaceMod(Constants.DAMAGE_MOD_50);
            if (pyromancer.getHP() + Constants.HP_MOD_30 > pyromancer.calculateTheoreticalHP()) {
                pyromancer.setHP(pyromancer.calculateTheoreticalHP());
            } else {
                pyromancer.addHP(Constants.HP_MOD_30);
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
            rogue.increaseRaceMod(Constants.DAMAGE_MOD_40);
            if (rogue.getHP() + Constants.HP_MOD_40 > rogue.calculateTheoreticalHP()) {
                rogue.setHP(rogue.calculateTheoreticalHP());
            } else {
                rogue.addHP(Constants.HP_MOD_40);
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
            wizard.increaseRaceMod(Constants.DAMAGE_MOD_30);
            if (wizard.getHP() + Constants.HP_MOD_50 > wizard.calculateTheoreticalHP()) {
                wizard.setHP(wizard.calculateTheoreticalHP());
            } else {
                wizard.addHP(Constants.HP_MOD_50);
            }
            notifyHelp(wizard);
        }
    }
}
