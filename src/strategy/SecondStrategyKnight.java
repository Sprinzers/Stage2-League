package strategy;

import champion.Knight;
import util.Constants;

public class SecondStrategyKnight implements StrategyKnight {

    @Override
    public void doStrategy(Knight knight) {
        knight.reduceRaceMod(Constants.DAMAGE_MOD_20);
        int hpAddition = knight.getHP() / 4;
        if (knight.getHP() + hpAddition > knight.calculateTeoreticalHP()) {
            knight.setHP(knight.calculateTeoreticalHP());
        } else {
            knight.addHP(hpAddition);
        }
    }
}
