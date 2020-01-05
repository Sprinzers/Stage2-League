package strategy;

import champion.Rogue;
import util.Constants;

public class SecondStrategyRogue implements StrategyRogue {

    /**
     *  Method used for the defensive strategy.
     * @param rogue champion applying the strategy
     */
    @Override
    public void doStrategy(final Rogue rogue) {
        rogue.reduceRaceMod(Constants.DAMAGE_MOD_10);
        int hpAddition = rogue.getHP() / Constants.ROGUE_DEFENSIVE;
        if (rogue.getHP() + hpAddition > rogue.calculateTeoreticalHP()) {
            rogue.setHP(rogue.calculateTeoreticalHP());
        } else {
            rogue.addHP(hpAddition);
        }
    }
}
