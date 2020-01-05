package strategy;

import champion.Rogue;
import util.Constants;

public class FirstStrategyRogue implements StrategyRogue {
    /**
     *  Method used for the offensive strategy of the rogue.
     * @param rogue champion applying the strategy
     */
    @Override
    public void doStrategy(final Rogue rogue) {
        int hpLoss = rogue.getHP() / Constants.ROGUE_STRATEGY_HP_LOSS;
        rogue.reduceHP(hpLoss);
        rogue.increaseRaceMod(Constants.DAMAGE_MOD_40);
    }
}
