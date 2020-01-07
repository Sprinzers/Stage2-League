package strategy;

import champion.Wizard;
import util.Constants;

public class SecondStrategyWizard implements StrategyWizard {
    /**
     *  Method used for the defensive strategy.
     * @param wizard champion applying the strategy
     */
    @Override
    public void doStrategy(final Wizard wizard) {
        wizard.reduceRaceMod(Constants.DAMAGE_MOD_20);
        int hpAddition = wizard.getHP() / Constants.WIZARD_DEFENSIVE;
        if (wizard.getHP() + hpAddition > wizard.calculateTheoreticalHP()) {
            wizard.setHP(wizard.calculateTheoreticalHP());
        } else {
            wizard.addHP(hpAddition);
        }
    }
}
