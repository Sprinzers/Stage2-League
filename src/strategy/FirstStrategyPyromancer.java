package strategy;

import champion.Pyromancer;
import util.Constants;

public class FirstStrategyPyromancer implements StrategyPyromancer {

    @Override
    public void doStrategy(Pyromancer pyromancer) {
        int hpLoss = pyromancer.getHP() / 4;
        pyromancer.reduceHP(hpLoss);
        pyromancer.increaseRaceMod(Constants.DAMAGE_MOD_70);
    }
}
