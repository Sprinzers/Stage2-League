package angel;

import champion.Knight;
import champion.Pyromancer;
import champion.Rogue;
import champion.Wizard;
import util.Constants;

import java.io.IOException;

public class SmallAngel extends Angel {

    public SmallAngel(final int posX, final int posY) {
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
            knight.increaseRaceMod(Constants.DAMAGE_MOD_10);
            if (knight.getHP() + Constants.HP_MOD_10 > knight.calculateTeoreticalHP()) {
                knight.setHP(knight.calculateTeoreticalHP());
            } else {
                knight.addHP(Constants.HP_MOD_10);
            }
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
            pyromancer.increaseRaceMod(Constants.DAMAGE_MOD_15);
            if (pyromancer.getHP() + Constants.HP_MOD_15 > pyromancer.calculateTeoreticalHP()) {
                pyromancer.setHP(pyromancer.calculateTeoreticalHP());
            } else {
                pyromancer.addHP(Constants.HP_MOD_15);
            }
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
            rogue.increaseRaceMod(Constants.DAMAGE_MOD_5);
            if (rogue.getHP() + Constants.HP_MOD_20 > rogue.calculateTeoreticalHP()) {
                rogue.setHP(rogue.calculateTeoreticalHP());
            } else {
                rogue.addHP(Constants.HP_MOD_20);
            }
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
            wizard.increaseRaceMod(Constants.DAMAGE_MOD_10);
            if (wizard.getHP() + Constants.HP_MOD_25 > wizard.calculateTeoreticalHP()) {
                wizard.setHP(wizard.calculateTeoreticalHP());
            } else {
                wizard.addHP(Constants.HP_MOD_25);
            }
            notifyHelp(wizard);
        }
    }
}
