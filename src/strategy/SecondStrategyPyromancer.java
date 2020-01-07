package strategy;

import champion.Pyromancer;
import util.Constants;

public class SecondStrategyPyromancer implements StrategyPyromancer {

    /**
     *  Method used for the defensive strategy.
     * @param pyromancer
     */
    @Override
    public void doStrategy(final Pyromancer pyromancer) {
        pyromancer.reduceRaceMod(Constants.DAMAGE_MOD_30);
        int hpAddition = pyromancer.getHP() / Constants.PYROMANCER_DEFENSIVE;
        if (pyromancer.getHP() + hpAddition > pyromancer.calculateTheoreticalHP()) {
            pyromancer.setHP(pyromancer.calculateTheoreticalHP());
        } else {
            pyromancer.addHP(hpAddition);
        }
    }
}
