package strategy;

import champion.Wizard;
import util.Constants;

public class FirstStrategyWizard implements StrategyWizard {
    /**
     *  Method used for the offensive strategy of the wizard.
     * @param wizard champion applying the strategy.
     */
    @Override
    public void doStrategy(final Wizard wizard) {
        int hpLoss = wizard.getHP() / Constants.WIZARD_STRATEGY_HP_LOSS;
        wizard.reduceHP(hpLoss);
        wizard.increaseRaceMod(Constants.DAMAGE_MOD_60);
    }
}
