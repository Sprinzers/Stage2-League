package strategy;

import champion.Wizard;
import util.Constants;

public class SecondStrategyWizard implements StrategyWizard {

    @Override
    public void doStrategy(Wizard wizard) {
        wizard.reduceRaceMod(Constants.DAMAGE_MOD_20);
        int hpAddition = wizard.getHP() / 5;
        if (wizard.getHP() + hpAddition > wizard.calculateTeoreticalHP()) {
            wizard.setHP(wizard.calculateTeoreticalHP());
        } else {
            wizard.addHP(hpAddition);
        }
    }
}
