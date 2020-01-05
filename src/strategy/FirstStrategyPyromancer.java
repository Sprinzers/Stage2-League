package strategy;

import champion.Pyromancer;
import util.Constants;

public class FirstStrategyPyromancer implements StrategyPyromancer {
    /**
     *  Method used for the offensive strategy of the pyromancer.
     * @param pyromancer championg applying the strategy.
     */
    @Override
    public void doStrategy(final Pyromancer pyromancer) {
        int hpLoss = pyromancer.getHP() / Constants.PYROMANCER_STRATEGY_HP_LOSS;
        pyromancer.reduceHP(hpLoss);
        pyromancer.increaseRaceMod(Constants.DAMAGE_MOD_70);
    }
}
