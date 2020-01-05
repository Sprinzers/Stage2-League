package angel;

import champion.*;
import util.Constants;

import java.io.IOException;

public class Spawner extends Angel {

    public Spawner(final int posX, final int posY) {
        setPosX(posX);
        setPosY(posY);
    }

    public void notifyRevive(final Champion champion) throws IOException {
        getObserver().updateRevive(champion);
    }

    /**
     *  Method describes the effects of the angel.
     * @param knight champion that the effects will be applied on.
     */
    @Override
    public void applyEffect(final Knight knight) throws IOException {
        if (!knight.isAlive()) {
            knight.setHP(Constants.HP_MOD_200);
//            knight.setXP();
            notifyHelp(knight);
            notifyRevive(knight);
        }
    }
    /**
     *  Method describes the effects of the angel.
     * @param pyromancer champion that the effects will be applied on.
     */
    @Override
    public void applyEffect(final Pyromancer pyromancer) throws IOException {
        if (!pyromancer.isAlive()) {
            pyromancer.setHP(Constants.HP_MOD_150);
//            pyromancer.setXP();
            notifyHelp(pyromancer);
            notifyRevive(pyromancer);
        }
    }
    /**
     *  Method describes the effects of the angel.
     * @param rogue champion that the effects will be applied on.
     */
    @Override
    public void applyEffect(final Rogue rogue) throws IOException {
        if (!rogue.isAlive()) {
            rogue.setHP(Constants.HP_MOD_180);
//            rogue.setXP();
            notifyHelp(rogue);
            notifyRevive(rogue);
        }
    }
    /**
     *  Method describes the effects of the angel.
     * @param wizard champion that the effects will be applied on.
     */
    @Override
    public void applyEffect(final Wizard wizard) throws IOException {
        if (!wizard.isAlive()) {
            wizard.setHP(Constants.HP_MOD_120);
//            wizard.setXP();
            notifyHelp(wizard);
            notifyRevive(wizard);
        }
    }
}
