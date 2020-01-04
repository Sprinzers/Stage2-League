package strategy;

import champion.Rogue;
import util.Constants;

public class FirstStrategyRogue implements StrategyRogue {

    @Override
    public void doStrategy(Rogue rogue) {
        int hpLoss = rogue.getHP() / 7;
        rogue.reduceHP(hpLoss);
        rogue.increaseRaceMod(Constants.DAMAGE_MOD_40);
    }
}
