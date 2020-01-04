package strategy;

import champion.Pyromancer;
import util.Constants;

public class SecondStrategyPyromancer implements StrategyPyromancer {

    @Override
    public void doStrategy(Pyromancer pyromancer) {
        pyromancer.reduceRaceMod(Constants.DAMAGE_MOD_30);
        int hpAddition = pyromancer.getHP() / 3;
        if (pyromancer.getHP() + hpAddition > pyromancer.calculateTeoreticalHP()) {
            pyromancer.setHP(pyromancer.calculateTeoreticalHP());
        } else {
            pyromancer.addHP(hpAddition);
        }
    }
}
