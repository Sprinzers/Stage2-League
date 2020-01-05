package angel;

import champion.Champion;
import champion.Knight;
import champion.Pyromancer;
import champion.Rogue;
import champion.Wizard;
import util.Constants;

import java.io.IOException;

public class Spawner extends Angel {

    public Spawner(final int posX, final int posY) {
        setPosX(posX);
        setPosY(posY);
    }

    /**
     *  Method is used to notify the observer when a champion is revived by an angel.
     * @param champion
     * @throws IOException
     */
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
            notifyHelp(wizard);
            notifyRevive(wizard);
        }
    }
}
