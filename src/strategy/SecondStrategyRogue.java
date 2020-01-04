package strategy;

import champion.Rogue;
import util.Constants;

public class SecondStrategyRogue implements StrategyRogue {

    @Override
    public void doStrategy(Rogue rogue) {
        rogue.reduceRaceMod(Constants.DAMAGE_MOD_10);
        int hpAddition = rogue.getHP() / 2;
        if (rogue.getHP() + hpAddition > rogue.calculateTeoreticalHP()) {
            rogue.setHP(rogue.calculateTeoreticalHP());
        } else {
            rogue.addHP(hpAddition);
        }
    }
}
