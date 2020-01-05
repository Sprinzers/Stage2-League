package strategy;

import champion.Knight;
import util.Constants;

public class SecondStrategyKnight implements StrategyKnight {

    /**
     *  Method used for the defensive strategy.
     * @param knight champion applying the strategy.
     */
    @Override
    public void doStrategy(final Knight knight) {
        knight.reduceRaceMod(Constants.DAMAGE_MOD_20);
        int hpAddition = knight.getHP() / Constants.KNIGHT_DEFENSIVE;
        if (knight.getHP() + hpAddition > knight.calculateTeoreticalHP()) {
            knight.setHP(knight.calculateTeoreticalHP());
        } else {
            knight.addHP(hpAddition);
        }
    }
}
