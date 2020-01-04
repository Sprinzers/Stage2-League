package strategy;

import champion.Knight;
import util.Constants;

public class FirstStrategyKnight implements StrategyKnight {

    @Override
    public void doStrategy(Knight knight) {
        int hpLoss = knight.getHP() / 5;
        knight.reduceHP(hpLoss);
        knight.increaseRaceMod(Constants.DAMAGE_MOD_50);
    }
}
