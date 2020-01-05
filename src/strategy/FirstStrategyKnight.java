package strategy;

import champion.Knight;
import util.Constants;

public class FirstStrategyKnight implements StrategyKnight {
    /**
     *  Method used for the offensive strategy of the knight.
     * @param knight champion applying the strategy
     */
    @Override
    public void doStrategy(final Knight knight) {
        int hpLoss = knight.getHP() / Constants.KNIGHT_STRATEGY_HP_LOSS;
        knight.reduceHP(hpLoss);
        knight.increaseRaceMod(Constants.DAMAGE_MOD_50);
    }
}
